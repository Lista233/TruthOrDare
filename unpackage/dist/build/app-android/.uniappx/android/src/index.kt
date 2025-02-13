@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER")
package uni.UNI00DFA61;
import io.dcloud.uniapp.*;
import io.dcloud.uniapp.extapi.*;
import io.dcloud.uniapp.framework.*;
import io.dcloud.uniapp.runtime.*;
import io.dcloud.uniapp.vue.*;
import io.dcloud.uniapp.vue.shared.*;
import io.dcloud.uts.*;
import io.dcloud.uts.Map;
import io.dcloud.uts.Set;
import io.dcloud.uts.UTSAndroid;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.async;
import io.dcloud.uniapp.extapi.exit as uni_exit;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
val runBlock1 = run {
    __uniConfig.getAppStyles = fun(): Map<String, Map<String, Map<String, Any>>> {
        return GenApp.styles;
    }
    ;
}
var firstBackTime: Number = 0;
open class GenGlobalData {
    open var randomlist = utsArrayOf<Number>();
}
open class GenApp : BaseApp {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onLaunch(fun(_: OnLaunchOptions) {
            console.log("App Launch");
        }
        , __ins);
        onAppShow(fun(_: OnShowOptions) {
            console.log("App Show");
        }
        , __ins);
        onAppHide(fun() {
            console.log("App Hide");
        }
        , __ins);
        onLastPageBackPress(fun() {
            console.log("App LastPageBackPress");
            if (firstBackTime == 0) {
                uni_showToast(ShowToastOptions(title = "再按一次退出应用", position = "bottom"));
                firstBackTime = Date.now();
                setTimeout(fun(){
                    firstBackTime = 0;
                }, 2000);
            } else if (Date.now() - firstBackTime < 2000) {
                firstBackTime = Date.now();
                uni_exit(null);
            }
        }
        , __ins);
        onExit(fun() {
            console.log("App Exit");
        }
        , __ins);
    }
    open val globalData: GenGlobalData
        get() {
            return getApp().globalData;
        }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            normalizeCssStyles(utsArrayOf(
                styles0
            ))
        };
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("uni-row" to padStyleMapOf(utsMapOf("flexDirection" to "row")), "uni-column" to padStyleMapOf(utsMapOf("flexDirection" to "column")));
            }
    }
}
val GenAppClass = CreateVueAppComponent(GenApp::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "app", name = "", inheritAttrs = true, inject = Map(), props = Map(), propsNeedCastKeys = utsArrayOf(), emits = Map(), components = Map(), styles = GenApp.styles);
}
, fun(instance): GenApp {
    return GenApp(instance);
}
);
val GenPagesIndexIndexClass = CreateVueComponent(GenPagesIndexIndex::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesIndexIndex.inheritAttrs, inject = GenPagesIndexIndex.inject, props = GenPagesIndexIndex.props, propsNeedCastKeys = GenPagesIndexIndex.propsNeedCastKeys, emits = GenPagesIndexIndex.emits, components = GenPagesIndexIndex.components, styles = GenPagesIndexIndex.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesIndexIndex.setup(props as GenPagesIndexIndex);
    }
    );
}
, fun(instance): GenPagesIndexIndex {
    return GenPagesIndexIndex(instance);
}
);
val GenPagesGameStartClass = CreateVueComponent(GenPagesGameStart::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesGameStart.inheritAttrs, inject = GenPagesGameStart.inject, props = GenPagesGameStart.props, propsNeedCastKeys = GenPagesGameStart.propsNeedCastKeys, emits = GenPagesGameStart.emits, components = GenPagesGameStart.components, styles = GenPagesGameStart.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesGameStart.setup(props as GenPagesGameStart);
    }
    );
}
, fun(instance): GenPagesGameStart {
    return GenPagesGameStart(instance);
}
);
val GenPagesGameSettingClass = CreateVueComponent(GenPagesGameSetting::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesGameSetting.inheritAttrs, inject = GenPagesGameSetting.inject, props = GenPagesGameSetting.props, propsNeedCastKeys = GenPagesGameSetting.propsNeedCastKeys, emits = GenPagesGameSetting.emits, components = GenPagesGameSetting.components, styles = GenPagesGameSetting.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesGameSetting.setup(props as GenPagesGameSetting);
    }
    );
}
, fun(instance): GenPagesGameSetting {
    return GenPagesGameSetting(instance);
}
);
val GenPagesToolMenuClass = CreateVueComponent(GenPagesToolMenu::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesToolMenu.inheritAttrs, inject = GenPagesToolMenu.inject, props = GenPagesToolMenu.props, propsNeedCastKeys = GenPagesToolMenu.propsNeedCastKeys, emits = GenPagesToolMenu.emits, components = GenPagesToolMenu.components, styles = GenPagesToolMenu.styles);
}
, fun(instance): GenPagesToolMenu {
    return GenPagesToolMenu(instance);
}
);
val GenPagesToolTimerClass = CreateVueComponent(GenPagesToolTimer::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesToolTimer.inheritAttrs, inject = GenPagesToolTimer.inject, props = GenPagesToolTimer.props, propsNeedCastKeys = GenPagesToolTimer.propsNeedCastKeys, emits = GenPagesToolTimer.emits, components = GenPagesToolTimer.components, styles = GenPagesToolTimer.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesToolTimer.setup(props as GenPagesToolTimer);
    }
    );
}
, fun(instance): GenPagesToolTimer {
    return GenPagesToolTimer(instance);
}
);
val GenPagesToolVoicerClass = CreateVueComponent(GenPagesToolVoicer::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesToolVoicer.inheritAttrs, inject = GenPagesToolVoicer.inject, props = GenPagesToolVoicer.props, propsNeedCastKeys = GenPagesToolVoicer.propsNeedCastKeys, emits = GenPagesToolVoicer.emits, components = GenPagesToolVoicer.components, styles = GenPagesToolVoicer.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesToolVoicer.setup(props as GenPagesToolVoicer);
    }
    );
}
, fun(instance): GenPagesToolVoicer {
    return GenPagesToolVoicer(instance);
}
);
fun createApp(): UTSJSONObject {
    val app = createSSRApp(GenAppClass);
    return UTSJSONObject(Map<String, Any?>(utsArrayOf(
        utsArrayOf(
            "app",
            app
        )
    )));
}
fun main(app: IApp) {
    definePageRoutes();
    defineAppConfig();
    (createApp()["app"] as VueApp).mount(app, GenUniApp());
}
open class UniAppConfig : io.dcloud.uniapp.appframe.AppConfig {
    override var name: String = "TruthOrDare";
    override var appid: String = "__UNI__00DFA61";
    override var versionName: String = "1.1.0";
    override var versionCode: String = "110";
    override var uniCompilerVersion: String = "4.45";
    constructor() : super() {}
}
fun definePageRoutes() {
    __uniRoutes.push(UniPageRoute(path = "pages/index/index", component = GenPagesIndexIndexClass, meta = UniPageMeta(isQuit = true), style = utsMapOf("rpxCalcMaxDeviceWidth" to 9999, "pageOrientation" to "landscape")));
    __uniRoutes.push(UniPageRoute(path = "pages/game/start", component = GenPagesGameStartClass, meta = UniPageMeta(isQuit = false), style = utsMapOf("pageOrientation" to "landscape")));
    __uniRoutes.push(UniPageRoute(path = "pages/game/setting", component = GenPagesGameSettingClass, meta = UniPageMeta(isQuit = false), style = utsMapOf("pageOrientation" to "landscape")));
    __uniRoutes.push(UniPageRoute(path = "pages/tool/menu", component = GenPagesToolMenuClass, meta = UniPageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "")));
    __uniRoutes.push(UniPageRoute(path = "pages/tool/timer", component = GenPagesToolTimerClass, meta = UniPageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "")));
    __uniRoutes.push(UniPageRoute(path = "pages/tool/voicer", component = GenPagesToolVoicerClass, meta = UniPageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "")));
}
val __uniLaunchPage: Map<String, Any?> = utsMapOf("url" to "pages/index/index", "style" to utsMapOf("rpxCalcMaxDeviceWidth" to 9999, "pageOrientation" to "landscape"));
fun defineAppConfig() {
    __uniConfig.entryPagePath = "/pages/index/index";
    __uniConfig.globalStyle = utsMapOf("rpxCalcMaxDeviceWidth" to 9999, "navigationBarTextStyle" to "black", "navigationBarTitleText" to "uni-app x", "navigationBarBackgroundColor" to "#F8F8F8", "backgroundColor" to "#F8F8F8", "navigationStyle" to "custom", "hideStatusBar" to true, "hideBottomNavigationIndicator" to true, "pageOrientation" to "landscape");
    __uniConfig.getTabBarConfig = fun(): Map<String, Any>? {
        return null;
    }
    ;
    __uniConfig.tabBar = __uniConfig.getTabBarConfig();
    __uniConfig.conditionUrl = "";
    __uniConfig.uniIdRouter = utsMapOf();
    __uniConfig.ready = true;
}
open class GenUniApp : UniAppImpl() {
    open val vm: GenApp?
        get() {
            return getAppVm() as GenApp?;
        }
    open val `$vm`: GenApp?
        get() {
            return getAppVm() as GenApp?;
        }
    open var globalData = GenGlobalData();
}
fun getApp(): GenUniApp {
    return getUniApp() as GenUniApp;
}
