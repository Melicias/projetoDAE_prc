import Vue from 'vue'
import Router from 'vue-router'
import { normalizeURL, decode } from 'ufo'
import { interopDefault } from './utils'
import scrollBehavior from './router.scrollBehavior.js'

const _2718db7f = () => interopDefault(import('..\\pages\\admin\\index.vue' /* webpackChunkName: "pages/admin/index" */))
const _8200876e = () => interopDefault(import('..\\pages\\profissionalSaude\\index.vue' /* webpackChunkName: "pages/profissionalSaude/index" */))
const _877f2c62 = () => interopDefault(import('..\\pages\\tipoProfissional\\index.vue' /* webpackChunkName: "pages/tipoProfissional/index" */))
const _098afe8d = () => interopDefault(import('..\\pages\\utente\\index.vue' /* webpackChunkName: "pages/utente/index" */))
const _facf60da = () => interopDefault(import('..\\pages\\admin\\biometricdata\\index.vue' /* webpackChunkName: "pages/admin/biometricdata/index" */))
const _1e84fef1 = () => interopDefault(import('..\\pages\\admin\\patients\\index.vue' /* webpackChunkName: "pages/admin/patients/index" */))
const _e5950784 = () => interopDefault(import('..\\pages\\admin\\professionaltype\\index.vue' /* webpackChunkName: "pages/admin/professionaltype/index" */))
const _1520f153 = () => interopDefault(import('..\\pages\\admin\\specialists\\index.vue' /* webpackChunkName: "pages/admin/specialists/index" */))
const _0ee48b95 = () => interopDefault(import('..\\pages\\auth\\login.vue' /* webpackChunkName: "pages/auth/login" */))
const _8467c3a8 = () => interopDefault(import('..\\pages\\profissionalSaude\\addPacient.vue' /* webpackChunkName: "pages/profissionalSaude/addPacient" */))
const _1efd504f = () => interopDefault(import('..\\pages\\profissionalSaude\\createPacient.vue' /* webpackChunkName: "pages/profissionalSaude/createPacient" */))
const _1d903b08 = () => interopDefault(import('..\\pages\\profissionalSaude\\createPrc.vue' /* webpackChunkName: "pages/profissionalSaude/createPrc" */))
const _e4ec032a = () => interopDefault(import('..\\pages\\profissionalSaude\\managePrescriptions.vue' /* webpackChunkName: "pages/profissionalSaude/managePrescriptions" */))
const _5b15214e = () => interopDefault(import('..\\pages\\profissionalSaude\\pacientManagement.vue' /* webpackChunkName: "pages/profissionalSaude/pacientManagement" */))
const _25ac4f3b = () => interopDefault(import('..\\pages\\profissionalSaude\\pacientsManagement.vue' /* webpackChunkName: "pages/profissionalSaude/pacientsManagement" */))
const _7535eec5 = () => interopDefault(import('..\\pages\\utente\\biometricdata\\index.vue' /* webpackChunkName: "pages/utente/biometricdata/index" */))
const _5bdce638 = () => interopDefault(import('..\\pages\\utente\\prescritions\\index.vue' /* webpackChunkName: "pages/utente/prescritions/index" */))
const _4403b644 = () => interopDefault(import('..\\pages\\utente\\profile\\index.vue' /* webpackChunkName: "pages/utente/profile/index" */))
const _0fb424ea = () => interopDefault(import('..\\pages\\admin\\biometricdata\\create.vue' /* webpackChunkName: "pages/admin/biometricdata/create" */))
const _412e5640 = () => interopDefault(import('..\\pages\\admin\\professionaltype\\create.vue' /* webpackChunkName: "pages/admin/professionaltype/create" */))
const _929cf86a = () => interopDefault(import('..\\pages\\admin\\specialists\\create.vue' /* webpackChunkName: "pages/admin/specialists/create" */))
const _593c3499 = () => interopDefault(import('..\\pages\\utente\\biometricdata\\create.vue' /* webpackChunkName: "pages/utente/biometricdata/create" */))
const _25d44e2b = () => interopDefault(import('..\\pages\\admin\\biometricdata\\_name.vue' /* webpackChunkName: "pages/admin/biometricdata/_name" */))
const _a45301e4 = () => interopDefault(import('..\\pages\\admin\\patients\\_email.vue' /* webpackChunkName: "pages/admin/patients/_email" */))
const _ea8e4e28 = () => interopDefault(import('..\\pages\\admin\\specialists\\_email.vue' /* webpackChunkName: "pages/admin/specialists/_email" */))
const _f141d2c0 = () => interopDefault(import('..\\pages\\utente\\prescritions\\_id.vue' /* webpackChunkName: "pages/utente/prescritions/_id" */))
const _d23950b4 = () => interopDefault(import('..\\pages\\index.vue' /* webpackChunkName: "pages/index" */))

const emptyFn = () => {}

Vue.use(Router)

export const routerOptions = {
  mode: 'history',
  base: '/',
  linkActiveClass: 'nuxt-link-active',
  linkExactActiveClass: 'nuxt-link-exact-active',
  scrollBehavior,

  routes: [{
    path: "/admin",
    component: _059fd822,
    name: "admin"
  }, {
    path: "/profissionalSaude",
    component: _8200876e,
    name: "profissionalSaude"
  }, {
    path: "/tipoProfissional",
    component: _3bae8b5f,
    name: "tipoProfissional"
  }, {
    path: "/utente",
    component: _134a57c6,
    name: "utente"
  }, {
    path: "/admin/biometricdata",
    component: _73fb2923,
    name: "admin-biometricdata"
  }, {
    path: "/admin/patients",
    component: _a1f7293e,
    name: "admin-patients"
  }, {
    path: "/admin/professionaltype",
    component: _290d0ea4,
    name: "admin-professionaltype"
  }, {
    path: "/admin/specialists",
    component: _718ceee3,
    name: "admin-specialists"
  }, {
    path: "/auth/login",
    component: _15cc8525,
    name: "auth-login"
  }, {
    path: "/profissionalSaude/addPacient",
    component: _8467c3a8,
    name: "profissionalSaude-addPacient"
  }, {
    path: "/profissionalSaude/createPacient",
    component: _1efd504f,
    name: "profissionalSaude-createPacient"
  }, {
    path: "/profissionalSaude/createPrc",
    component: _1d903b08,
    name: "profissionalSaude-createPrc"
  }, {
    path: "/profissionalSaude/managePrescriptions",
    component: _e4ec032a,
    name: "profissionalSaude-managePrescriptions"
  }, {
    path: "/profissionalSaude/pacientManagement",
    component: _5b15214e,
    name: "profissionalSaude-pacientManagement"
  }, {
    path: "/profissionalSaude/pacientsManagement",
    component: _25ac4f3b,
    name: "profissionalSaude-pacientsManagement"
  }, {
    path: "/utente/biometricdata",
    component: _9fa37196,
    name: "utente-biometricdata"
  }, {
    path: "/utente/prescritions",
    component: _4d3fbfc8,
    name: "utente-prescritions"
  }, {
    path: "/utente/profile",
    component: _6e7d914e,
    name: "utente-profile"
  }, {
    path: "/admin/biometricdata/create",
    component: _331e45fb,
    name: "admin-biometricdata-create"
  }, {
    path: "/admin/professionaltype/create",
    component: _a92c3060,
    name: "admin-professionaltype-create"
  }, {
    path: "/admin/specialists/create",
    component: _30758f8a,
    name: "admin-specialists-create"
  }, {
    path: "/utente/biometricdata/create",
    component: _7d4eea29,
    name: "utente-biometricdata-create"
  }, {
    path: "/admin/biometricdata/:name",
    component: _173727bb,
    name: "admin-biometricdata-name"
  }, {
    path: "/admin/patients/:email",
    component: _2d44a09e,
    name: "admin-patients-email"
  }, {
    path: "/admin/specialists/:email",
    component: _8866e548,
    name: "admin-specialists-email"
  }, {
    path: "/utente/prescritions/:id",
    component: _3869d7a0,
    name: "utente-prescritions-id"
  }, {
    path: "/",
    component: _0369bd36,
    name: "index"
  }],

  fallback: false
}

export function createRouter (ssrContext, config) {
  const base = (config._app && config._app.basePath) || routerOptions.base
  const router = new Router({ ...routerOptions, base  })

  // TODO: remove in Nuxt 3
  const originalPush = router.push
  router.push = function push (location, onComplete = emptyFn, onAbort) {
    return originalPush.call(this, location, onComplete, onAbort)
  }

  const resolve = router.resolve.bind(router)
  router.resolve = (to, current, append) => {
    if (typeof to === 'string') {
      to = normalizeURL(to)
    }
    return resolve(to, current, append)
  }

  return router
}
