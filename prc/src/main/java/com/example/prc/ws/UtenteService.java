package com.example.prc.ws;

import com.example.prc.dtos.TipoProfissionalDTO;
import com.example.prc.dtos.UtenteDTO;
import com.example.prc.ejbs.PrescricaoBean;
import com.example.prc.ejbs.ProfissionalSaudeBean;
import com.example.prc.ejbs.TipoProfissionalBean;
import com.example.prc.ejbs.UtenteBean;
import com.example.prc.entities.TipoDadosBiometricos;
import com.example.prc.entities.User;
import com.example.prc.entities.Utente;
import com.example.prc.jwt.Jwt;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static io.smallrye.config.ConfigLogging.log;

@Path("utente")
@Produces({MediaType.APPLICATION_JSON}) // injects header “Content-Type: application/json”
@Consumes({MediaType.APPLICATION_JSON}) // injects header “Accept: application/json”
public class UtenteService {
    @EJB
    private UtenteBean utenteBean;
    @EJB
    private ProfissionalSaudeBean profissionalSaudeBean;
    @EJB
    private PrescricaoBean prescricaoBean;

    @GET
    @Path("/")
    public List<UtenteDTO> getTipoProfissionalWS() {
        System.out.println("AQUI GET"+toDTOs(utenteBean.getAllUtente())+"vamos");
        return toDTOs(utenteBean.getAllUtente());
    }

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUtente(UtenteDTO utenteDTO) {
        try {
            System.out.println("HELLO "+utenteDTO.getDataNasc());
            utenteBean.create(utenteDTO.getPassword(),
                    utenteDTO.getName(),
                    utenteDTO.getEmail(),
                    new Date("29/06/1999"),
                    utenteDTO.getEmailProfissionalSaude());
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()+"Entrou catch").build();
        }
        return Response.ok(utenteDTO).build();
    }

    @POST
    @Path("/addprofissionalsaude")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProfissionalSaudeToUtente(UtenteDTO utenteDTO){
        try {
            utenteBean.addProfissionalSaude(utenteDTO.getEmail(), utenteDTO.getEmailProfissionalSaude());
            profissionalSaudeBean.addUtente(utenteDTO.getEmailProfissionalSaude(), utenteDTO.getEmail());
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()+"Entrou catch").build();
        }
        return  Response.ok(utenteDTO).build();
    }

    /*@POST
    @Path("/prescricao")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPrescricaoToUtente(UtenteDTO utenteDTO){
        try {
            prescricaoBean.crea(utenteDTO.getEmail(), utenteDTO.getEmailProfissionalSaude());
            profissionalSaudeBean.addUtente(utenteDTO.getEmailProfissionalSaude(), utenteDTO.getEmail());
        } catch (Exception e) {
            return Response.status(400).entity(e.getMessage()+"Entrou catch").build();
        }
        return  Response.ok(utenteDTO).build();
    }*/

    private UtenteDTO toDTO(Utente utente) {
        UtenteDTO ut = new UtenteDTO(
                utente.getEmail(),
                utente.getPassword(),
                utente.getName(),
                utente.getDeleted_at(),
                utente.getBlocked(),
                utente.getDataNasc(),
                utente.getProfissionalSaude()
        );
        return ut;
    }

    private List<UtenteDTO> toDTOs(List<Utente> utentes) {
        return utentes.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
