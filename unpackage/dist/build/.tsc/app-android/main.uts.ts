import App from './App.uvue'

import { createSSRApp } from 'vue'
export function createApp() {
	const app = createSSRApp(App)
	return {
		app
	}
}
export function main(app: IApp) {
    definePageRoutes();
    defineAppConfig();
    
    (createApp()['app'] as VueApp).mount(app, GenUniApp());
}

export class UniAppConfig extends io.dcloud.uniapp.appframe.AppConfig {
    override name: string = "TruthOrDare"
    override appid: string = "__UNI__00DFA61"
    override versionName: string = "1.1.0"
    override versionCode: string = "110"
    override uniCompilerVersion: string = "4.45"
    
    constructor() { super() }
}

import GenPagesIndexIndexClass from './pages/index/index.uvue?type=page'
import GenPagesGameStartClass from './pages/game/start.uvue?type=page'
import GenPagesGameSettingClass from './pages/game/setting.uvue?type=page'
import GenPagesToolMenuClass from './pages/tool/menu.uvue?type=page'
import GenPagesToolTimerClass from './pages/tool/timer.uvue?type=page'
import GenPagesToolVoicerClass from './pages/tool/voicer.uvue?type=page'
function definePageRoutes() {
__uniRoutes.push({ path: "pages/index/index", component: GenPagesIndexIndexClass, meta: { isQuit: true } as UniPageMeta, style: utsMapOf([["rpxCalcMaxDeviceWidth",9999],["pageOrientation","landscape"]]) } as UniPageRoute)
__uniRoutes.push({ path: "pages/game/start", component: GenPagesGameStartClass, meta: { isQuit: false } as UniPageMeta, style: utsMapOf([["pageOrientation","landscape"]]) } as UniPageRoute)
__uniRoutes.push({ path: "pages/game/setting", component: GenPagesGameSettingClass, meta: { isQuit: false } as UniPageMeta, style: utsMapOf([["pageOrientation","landscape"]]) } as UniPageRoute)
__uniRoutes.push({ path: "pages/tool/menu", component: GenPagesToolMenuClass, meta: { isQuit: false } as UniPageMeta, style: utsMapOf([["navigationBarTitleText",""]]) } as UniPageRoute)
__uniRoutes.push({ path: "pages/tool/timer", component: GenPagesToolTimerClass, meta: { isQuit: false } as UniPageMeta, style: utsMapOf([["navigationBarTitleText",""]]) } as UniPageRoute)
__uniRoutes.push({ path: "pages/tool/voicer", component: GenPagesToolVoicerClass, meta: { isQuit: false } as UniPageMeta, style: utsMapOf([["navigationBarTitleText",""]]) } as UniPageRoute)
}
const __uniTabBar: Map<string, any | null> | null = null
const __uniLaunchPage: Map<string, any | null> = utsMapOf([["url","pages/index/index"],["style",utsMapOf([["rpxCalcMaxDeviceWidth",9999],["pageOrientation","landscape"]])]])
function defineAppConfig(){
  __uniConfig.entryPagePath = '/pages/index/index'
  __uniConfig.globalStyle = utsMapOf([["rpxCalcMaxDeviceWidth",9999],["navigationBarTextStyle","black"],["navigationBarTitleText","uni-app x"],["navigationBarBackgroundColor","#F8F8F8"],["backgroundColor","#F8F8F8"],["navigationStyle","custom"],["hideStatusBar",true],["hideBottomNavigationIndicator",true],["pageOrientation","landscape"]])
  __uniConfig.getTabBarConfig = ():Map<string, any> | null =>  null
  __uniConfig.tabBar = __uniConfig.getTabBarConfig()
  __uniConfig.conditionUrl = ''
  __uniConfig.uniIdRouter = utsMapOf()
  
  __uniConfig.ready = true
}
