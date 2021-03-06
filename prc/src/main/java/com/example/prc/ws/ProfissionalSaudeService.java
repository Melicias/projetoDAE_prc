package com.example.prc.ws;

import com.example.prc.dtos.*;
import com.example.prc.ejbs.ProfissionalSaudeBean;
import com.example.prc.entities.*;
import com.example.prc.exceptions.MyConstraintViolationException;
import com.example.prc.exceptions.MyEntityExistsException;
import com.example.prc.exceptions.MyEntityNotFoundException;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("profissionalsaude")
@Produces({MediaType.APPLICATION_JSON}) // injects header “Content-Type: application/json”
@Consumes({MediaType.APPLICATION_JSON}) // injects header “Accept: application/json”
public class ProfissionalSaudeService {
    @EJB
    private ProfissionalSaudeBean profissionalSaudeBean;

    @GET
    @Path("/")
    public List<ProfissionalSaudeDTO> getTipoProfissionalWS() {
        return toDTOs(profissionalSaudeBean.getAllProfissionalSaude());
    }

    @GET
    @Path("{email}")
    public Response getTipoProfissional(@PathParam("email") String email) throws MyEntityNotFoundException {
        ProfissionalSaude ps = profissionalSaudeBean.findTipoProfissional(email);
        return Response.ok(toDTOComplete(ps)).build();
    }

    @DELETE
    @RolesAllowed({"Admin"})
    @Path("{email}")
    public Response deleteTipoProfissional(@PathParam("email") String email) throws MyEntityNotFoundException {
        try{
            ProfissionalSaude profissionalSaude = profissionalSaudeBean.deleteProfissionalSaude(email);
            if(profissionalSaude == null)
                return Response.ok(null).build();

            return Response.ok(toDTO(profissionalSaude)).build();
        }catch (Exception e){
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @PUT
    @RolesAllowed({"Admin"})
    @Path("/")
    public Response putProfissionalSaude(ProfissionalSaudeDTO profissionalSaudeDTO)
            throws MyEntityNotFoundException, MyConstraintViolationException {
        try{
            profissionalSaudeBean.update(
                    profissionalSaudeDTO.getEmail(),
                    profissionalSaudeDTO.getName(),
                    profissionalSaudeDTO.getPassword(),
                    profissionalSaudeDTO.getTipoProfissional().getId());
        }catch (Exception e){
            return Response.status(400).entity(e.getMessage()).build();
        }
        return Response.ok(profissionalSaudeDTO).build();
    }

    @PUT
    @RolesAllowed({"Admin"})
    @Path("/block/{email}")
    public Response blockProfissionalSaude(@PathParam("email") String email)
            throws MyEntityNotFoundException {
        try{
            ProfissionalSaude profissionalSaude = profissionalSaudeBean.blockProfissionalSaude(email);
            return Response.ok(toDTO(profissionalSaude)).build();
        }catch (Exception e){
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @POST
    @RolesAllowed({"Admin"})
    @Path("/")
    public Response createProfissionalSaude (ProfissionalSaudeDTO profissionalSaude)
            throws MyEntityExistsException, MyEntityNotFoundException, MyConstraintViolationException {
        try{
            profissionalSaudeBean.create(
                    profissionalSaude.getPassword(),
                    profissionalSaude.getName(),
                    profissionalSaude.getEmail(),
                    profissionalSaude.getTipoProfissional().getId());
        }catch (Exception e){
            return Response.status(400).entity(e.getMessage()).build();
        }
        return Response.ok(profissionalSaude).build();
    }

    @PUT
    @RolesAllowed({"Admin","ProfissionalSaude"})
    @Path("{emailprofissional}")
    public Response updateProfissionalSaudePassword (@PathParam("emailprofissional") String emailprofissional, ProfissionalSaudeDTO profissionalSaude)
            throws MyEntityExistsException, MyEntityNotFoundException, MyConstraintViolationException {
        try{
            profissionalSaudeBean.updatePassword(
                    emailprofissional,
                    profissionalSaude.getPassword(),
                    profissionalSaude.getNewPassword(),
                    profissionalSaude.getConfirmPassword());
        }catch (Exception e){
            return Response.status(400).entity(e.getMessage()).build();
        }
        return Response.ok(profissionalSaude).build();
    }

    @POST
    @RolesAllowed({"Admin","ProfissionalSaude"})
    @Path("/addUtente/{emailprofissional}")
    public Response addUtenteToProfissionalSaude (@PathParam("emailprofissional") String emailprofissional, UtenteDTO utenteDTO)
            throws MyEntityNotFoundException, MyConstraintViolationException {
        try{
            Utente utente = profissionalSaudeBean.addUtente(emailprofissional, utenteDTO.getEmail());
            return Response.ok(toDTOUtente(utente)).build();
        }catch (Exception e){
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @POST
    @RolesAllowed({"Admin","ProfissionalSaude"})
    @Path("/removeUtente/{emailprofissional}")
    public Response removeUtenteToProfissionalSaude (@PathParam("emailprofissional") String emailprofissional, UtenteDTO utenteDTO)
            throws MyEntityNotFoundException, MyConstraintViolationException {
        try{
            Utente utente = profissionalSaudeBean.removeUtente(emailprofissional, utenteDTO.getEmail());
            return Response.ok(toDTOUtente(utente)).build();
        }catch (Exception e){
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @GET
    @RolesAllowed({"Admin","ProfissionalSaude"})
    @Path("/profissionaissemutente/{utenteemail}")
    public Response getProfissionaSemUtente(@PathParam("utenteemail") String utenteemail) throws MyEntityNotFoundException {
        try{
            List<ProfissionalSaude> profissionalSaudes = profissionalSaudeBean.getProfissionaisSemUtente(utenteemail);
            return Response.ok(toDTOs(profissionalSaudes)).build();
        }catch (Exception e){
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    private ProfissionalSaudeDTO toDTOComplete(ProfissionalSaude profissionalSaude) {
        ProfissionalSaudeDTO profissionaSaudeDTO = new ProfissionalSaudeDTO(
                profissionalSaude.getEmail(),
                profissionalSaude.getPassword(),
                profissionalSaude.getName(),
                profissionalSaude.getDeleted_at(),
                profissionalSaude.getBlocked(),
                toDTOTipoProfissional(profissionalSaude.getTipoProfissional())
        );
        List<UtenteDTO> utentesDTOS = toDTOUtentes(profissionalSaude.getUtentes());
        profissionaSaudeDTO.setUtentes(utentesDTOS);
        List<PrcDTO> prcsDTOS = toDTOPrcs(profissionalSaude.getPrcs());
        profissionaSaudeDTO.setPrcs(prcsDTOS);
        return profissionaSaudeDTO;
    }

    public ProfissionalSaudeDTO toDTO(ProfissionalSaude profissionalSaude) {
        ProfissionalSaudeDTO profissionaSaudeDTO = new ProfissionalSaudeDTO(
                profissionalSaude.getEmail(),
                profissionalSaude.getPassword(),
                profissionalSaude.getName(),
                profissionalSaude.getDeleted_at(),
                profissionalSaude.getBlocked(),
                toDTOTipoProfissional(profissionalSaude.getTipoProfissional())
        );
        return profissionaSaudeDTO;
    }

    private TipoProfissionalDTO toDTOTipoProfissional(TipoProfissional tipoProfissional) {
        TipoProfissionalDTO tp = new TipoProfissionalDTO(
                tipoProfissional.getId(),
                tipoProfissional.getName(),
                tipoProfissional.getDeleted_at()
        );
        return tp;
    }


    private UtenteDTO toDTOUtente(Utente utente) {
        return new UtenteDTO(
                utente.getEmail(),
                "",
                utente.getName(),
                utente.getDataNasc(),
                utente.getDeleted_at(),
                utente.getBlocked()
        );
    }

    private List<UtenteDTO> toDTOUtentes(List<Utente> utentes) {
        return utentes.stream().map(this::toDTOUtente).collect(Collectors.toList());
    }

    private PrcDTO toDTOPrc(Prc prc) {
        PrcDTO prcDTO = new PrcDTO(
                prc.getId(),
                toDTOUtente(prc.getUtente()),
                toDTO(prc.getProfissionalSaude()),
                prc.getDoenca(),
                prc.getValidade(),
                prc.getCreated_at(),
                prc.getDeleted_at()
        );
        PrescricaoService ps = new PrescricaoService();
        prcDTO.setPrescricoes(ps.toDTOs(prc.getPrescricoes()));
        return prcDTO;
    }

    private List<PrcDTO> toDTOPrcs(List<Prc> prcs) {
        return prcs.stream().map(this::toDTOPrc).collect(Collectors.toList());
    }

    public List<ProfissionalSaudeDTO> toDTOs(List<ProfissionalSaude> profissionalSaude) {
        return profissionalSaude.stream().map(this::toDTO).collect(Collectors.toList());
    }


}
