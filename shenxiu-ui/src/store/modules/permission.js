import auth from '@/plugins/auth'
import router, { constantRoutes, dynamicRoutes } from '@/router'
import { getRouters } from '@/api/menu'
import Layout from '@/layout/index'
import ParentView from '@/components/ParentView'
import InnerLink from '@/layout/components/InnerLink'

const permission = {
  state: {
    routes: [],
    addRoutes: [],
    defaultRoutes: [],
    topbarRouters: [],
    sidebarRouters: []
  },
  mutations: {
    SET_ROUTES: (state, routes) => {
      state.addRoutes = routes
      state.routes = constantRoutes.concat(routes)
    },
    SET_DEFAULT_ROUTES: (state, routes) => {
      state.defaultRoutes = constantRoutes.concat(routes)
    },
    SET_TOPBAR_ROUTES: (state, routes) => {
      state.topbarRouters = routes
    },
    SET_SIDEBAR_ROUTERS: (state, routes) => {
      state.sidebarRouters = routes
    },
  },
  actions: {
    // 生成路由
    GenerateRoutes({ commit }) {
      return new Promise(resolve => {
        // 向后端请求路由数据
        getRouters().then(res => {
          const sdata = JSON.parse(JSON.stringify(res.data))
          const rdata = JSON.parse(JSON.stringify(res.data))
          const sidebarRoutes = filterAsyncRouter(sdata)
          const rewriteRoutes = filterAsyncRouter(rdata, false, true)
          const asyncRoutes = filterDynamicRoutes(dynamicRoutes);
          rewriteRoutes.push({ path: '*', redirect: '/404', hidden: true })
          router.addRoutes(asyncRoutes);
          commit('SET_ROUTES', rewriteRoutes)
          commit('SET_SIDEBAR_ROUTERS', constantRoutes.concat(sidebarRoutes))
          commit('SET_DEFAULT_ROUTES', sidebarRoutes)
          commit('SET_TOPBAR_ROUTES', sidebarRoutes)
          resolve(rewriteRoutes)
        })
      })
    },
    //临时路由
    TempGenerateRoutes({ commit }) {
      return new Promise(resolve => {
        const data = [
          {
            'name': '6666',
            'path': '/6666',
            'hidden': false,
            'redirect': 'noRedirect',
            'component': 'Layout',
            'alwaysShow': true,
            'meta': {
              'title': '傻逼菜单',
              'icon': '404',
              'noCache': false,
              'link': null
            },
            'children': [
              {
                'name': '7777',
                'path': '7777',
                'hidden': false,
                'component': '·1111',
                'query': '121212',
                'meta': {
                  'title': '二级傻逼',
                  'icon': 'bug',
                  'noCache': false,
                  'link': null
                }
              },
              {
                'name': 'Http://www.qq.com',
                'path': 'http://www.qq.com',
                'hidden': false,
                'component': 'Layout',
                'meta': {
                  'title': '你是傻逼',
                  'icon': 'clipboard',
                  'noCache': false,
                  'link': 'http://www.qq.com'
                }
              }
            ]
          },
          {
            'name': 'System',
            'path': '/system',
            'hidden': false,
            'redirect': 'noRedirect',
            'component': 'Layout',
            'alwaysShow': true,
            'meta': {
              'title': '系统管理',
              'icon': 'system',
              'noCache': false,
              'link': null
            },
            'children': [
              {
                'name': 'User',
                'path': 'user',
                'hidden': false,
                'component': 'system/user/index',
                'meta': {
                  'title': '用户管理',
                  'icon': 'user',
                  'noCache': false,
                  'link': null
                }
              },
              {
                'name': 'Role',
                'path': 'role',
                'hidden': false,
                'component': 'system/role/index',
                'meta': {
                  'title': '角色管理',
                  'icon': 'peoples',
                  'noCache': false,
                  'link': null
                }
              },
              {
                'name': 'Menu',
                'path': 'menu',
                'hidden': false,
                'component': 'system/menu/index',
                'meta': {
                  'title': '菜单管理',
                  'icon': 'tree-table',
                  'noCache': false,
                  'link': null
                }
              },
              {
                'name': 'Dept',
                'path': 'dept',
                'hidden': false,
                'component': 'system/dept/index',
                'meta': {
                  'title': '部门管理',
                  'icon': 'tree',
                  'noCache': false,
                  'link': null
                }
              },
              {
                'name': 'Post',
                'path': 'post',
                'hidden': false,
                'component': 'system/post/index',
                'meta': {
                  'title': '岗位管理',
                  'icon': 'post',
                  'noCache': false,
                  'link': null
                }
              },
              {
                'name': 'Dict',
                'path': 'dict',
                'hidden': false,
                'component': 'system/dict/index',
                'meta': {
                  'title': '字典管理',
                  'icon': 'dict',
                  'noCache': false,
                  'link': null
                }
              },
              {
                'name': 'DictData',
                'path': 'index',
                'hidden': true,
                'component': 'system/dict/data',
                'meta': {
                  'title': '字典数据',
                  'icon': 'dict',
                  'noCache': false,
                  'link': null
                }
              },
              {
                'name': 'Config',
                'path': 'config',
                'hidden': false,
                'component': 'system/config/index',
                'meta': {
                  'title': '参数设置',
                  'icon': 'edit',
                  'noCache': false,
                  'link': null
                }
              },
              {
                'name': 'Notice',
                'path': 'notice',
                'hidden': false,
                'component': 'system/notice/index',
                'meta': {
                  'title': '通知公告',
                  'icon': 'message',
                  'noCache': false,
                  'link': null
                }
              },
              {
                'name': 'Log',
                'path': 'log',
                'hidden': false,
                'redirect': 'noRedirect',
                'component': 'ParentView',
                'alwaysShow': true,
                'meta': {
                  'title': '日志管理',
                  'icon': 'log',
                  'noCache': false,
                  'link': null
                },
                'children': [
                  {
                    'name': 'Operlog',
                    'path': 'operlog',
                    'hidden': false,
                    'component': 'monitor/operlog/index',
                    'meta': {
                      'title': '操作日志',
                      'icon': 'form',
                      'noCache': false,
                      'link': null
                    }
                  },
                  {
                    'name': 'Logininfor',
                    'path': 'logininfor',
                    'hidden': false,
                    'component': 'monitor/logininfor/index',
                    'meta': {
                      'title': '登录日志',
                      'icon': 'logininfor',
                      'noCache': false,
                      'link': null
                    }
                  }
                ]
              },
              {
                'name': 'Oss',
                'path': 'oss',
                'hidden': false,
                'component': 'system/oss/index',
                'meta': {
                  'title': '文件管理',
                  'icon': 'upload',
                  'noCache': false,
                  'link': null
                }
              }
            ]
          },
          {
            'name': 'Monitor',
            'path': '/monitor',
            'hidden': false,
            'redirect': 'noRedirect',
            'component': 'Layout',
            'alwaysShow': true,
            'meta': {
              'title': '系统监控',
              'icon': 'monitor',
              'noCache': false,
              'link': null
            },
            'children': [
              {
                'name': 'Online',
                'path': 'online',
                'hidden': false,
                'component': 'monitor/online/index',
                'meta': {
                  'title': '在线用户',
                  'icon': 'online',
                  'noCache': false,
                  'link': null
                }
              },
              {
                'name': 'Cache',
                'path': 'cache',
                'hidden': false,
                'component': 'monitor/cache/index',
                'meta': {
                  'title': '缓存监控',
                  'icon': 'redis',
                  'noCache': false,
                  'link': null
                }
              },
              {
                'name': 'XxlJob',
                'path': 'XxlJob',
                'hidden': false,
                'component': 'monitor/xxljob/index',
                'meta': {
                  'title': '任务调度中心',
                  'icon': 'job',
                  'noCache': false,
                  'link': null
                }
              },
              {
                'name': 'Admin',
                'path': 'Admin',
                'hidden': false,
                'component': 'monitor/admin/index',
                'meta': {
                  'title': 'Admin监控',
                  'icon': 'dashboard',
                  'noCache': false,
                  'link': null
                }
              },
              {
                'name': 'CacheList',
                'path': 'cacheList',
                'hidden': false,
                'component': 'monitor/cache/list',
                'meta': {
                  'title': '缓存列表',
                  'icon': 'redis-list',
                  'noCache': false,
                  'link': null
                }
              }
            ]
          },
          {
            'name': 'Tool',
            'path': '/tool',
            'hidden': false,
            'redirect': 'noRedirect',
            'component': 'Layout',
            'alwaysShow': true,
            'meta': {
              'title': '系统工具',
              'icon': 'tool',
              'noCache': false,
              'link': null
            },
            'children': [
              {
                'name': 'Build',
                'path': 'build',
                'hidden': false,
                'component': 'tool/build/index',
                'meta': {
                  'title': '表单构建',
                  'icon': 'build',
                  'noCache': false,
                  'link': null
                }
              },
              {
                'name': 'Gen',
                'path': 'gen',
                'hidden': false,
                'component': 'tool/gen/index',
                'meta': {
                  'title': '代码生成',
                  'icon': 'code',
                  'noCache': false,
                  'link': null
                }
              }
            ]
          },
          {
            'name': 'Https://gitee.com/JavaLionLi/RuoYi-Vue-Plus',
            'path': 'https://gitee.com/JavaLionLi/RuoYi-Vue-Plus',
            'hidden': false,
            'component': 'Layout',
            'meta': {
              'title': 'PLUS官网',
              'icon': 'guide',
              'noCache': false,
              'link': 'https://gitee.com/JavaLionLi/RuoYi-Vue-Plus'
            }
          },
          {
            'name': 'Demo',
            'path': '/demo',
            'hidden': false,
            'redirect': 'noRedirect',
            'component': 'Layout',
            'alwaysShow': true,
            'meta': {
              'title': '测试菜单',
              'icon': 'star',
              'noCache': false,
              'link': null
            },
            'children': [
              {
                'name': 'Demo',
                'path': 'demo',
                'hidden': false,
                'component': 'demo/demo/index',
                'meta': {
                  'title': '测试单表',
                  'icon': '#',
                  'noCache': false,
                  'link': null
                }
              },
              {
                'name': 'Tree',
                'path': 'tree',
                'hidden': false,
                'component': 'demo/tree/index',
                'meta': {
                  'title': '测试树表',
                  'icon': '#',
                  'noCache': false,
                  'link': null
                }
              }
            ]
          }
        ]
        const sdata = JSON.parse(JSON.stringify(data))
        const rdata = JSON.parse(JSON.stringify(data))
        const sidebarRoutes = filterAsyncRouter(sdata)
        const rewriteRoutes = filterAsyncRouter(rdata, false, true)
        const asyncRoutes = filterDynamicRoutes(dynamicRoutes);
        rewriteRoutes.push({ path: '*', redirect: '/404', hidden: true })
        router.addRoutes(asyncRoutes);
        commit('SET_ROUTES', rewriteRoutes)
        commit('SET_SIDEBAR_ROUTERS', constantRoutes.concat(sidebarRoutes))
        commit('SET_DEFAULT_ROUTES', sidebarRoutes)
        commit('SET_TOPBAR_ROUTES', sidebarRoutes)
        resolve(rewriteRoutes)
      })
    }
  }
}

// 遍历后台传来的路由字符串，转换为组件对象
function filterAsyncRouter(asyncRouterMap, lastRouter = false, type = false) {
  return asyncRouterMap.filter(route => {
    if (type && route.children) {
      route.children = filterChildren(route.children)
    }
    if (route.component) {
      // Layout ParentView 组件特殊处理
      if (route.component === 'Layout') {
        route.component = Layout
      } else if (route.component === 'ParentView') {
        route.component = ParentView
      } else if (route.component === 'InnerLink') {
        route.component = InnerLink
      } else {
        route.component = loadView(route.component)
      }
    }
    if (route.children != null && route.children && route.children.length) {
      route.children = filterAsyncRouter(route.children, route, type)
    } else {
      delete route['children']
      delete route['redirect']
    }
    return true
  })
}

function filterChildren(childrenMap, lastRouter = false) {
  var children = []
  childrenMap.forEach((el, index) => {
    if (el.children && el.children.length) {
      if (el.component === 'ParentView' && !lastRouter) {
        el.children.forEach(c => {
          c.path = el.path + '/' + c.path
          if (c.children && c.children.length) {
            children = children.concat(filterChildren(c.children, c))
            return
          }
          children.push(c)
        })
        return
      }
    }
    if (lastRouter) {
      el.path = lastRouter.path + '/' + el.path
    }
    children = children.concat(el)
  })
  return children
}

// 动态路由遍历，验证是否具备权限
export function filterDynamicRoutes(routes) {
  const res = []
  routes.forEach(route => {
    if (route.permissions) {
      if (auth.hasPermiOr(route.permissions)) {
        res.push(route)
      }
    } else if (route.roles) {
      if (auth.hasRoleOr(route.roles)) {
        res.push(route)
      }
    }
  })
  return res
}

export const loadView = (view) => {
  if (process.env.NODE_ENV === 'development') {
    return (resolve) => require([`@/views/${view}`], resolve)
  } else {
    // 使用 import 实现生产环境的路由懒加载
    return () => import(`@/views/${view}`)
  }
}

export default permission
