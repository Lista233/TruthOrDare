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
open class GenPagesIndexIndex : BasePage {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _cache = this.`$`.renderCache;
        val _component_navigator = resolveComponent("navigator");
        return createElementVNode("view", utsMapOf("class" to "index"), utsArrayOf(
            createElementVNode("text", utsMapOf("class" to "menutitle"), " 真心话大冒险"),
            createElementVNode("view", utsMapOf("class" to "menubox"), utsArrayOf(
                createVNode(_component_navigator, utsMapOf("url" to "/pages/demo2/demo2", "class" to "menubtn"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        createElementVNode("view", utsMapOf("class" to "menunav"), utsArrayOf(
                            createElementVNode("image", utsMapOf("src" to "/static/start.png", "class" to "menuimg")),
                            createElementVNode("text", utsMapOf("class" to "menutext"), " 开始游戏 ")
                        ))
                    );
                }
                ), "_" to 1)),
                createVNode(_component_navigator, utsMapOf("url" to "/pages/demo2/demo3", "class" to "menubtn"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        createElementVNode("view", utsMapOf("class" to "menunav"), utsArrayOf(
                            createElementVNode("image", utsMapOf("src" to "/static/set.png", "class" to "menuimg2")),
                            createElementVNode("text", utsMapOf("class" to "menutext"), " 设置词条 ")
                        ))
                    );
                }
                ), "_" to 1))
            ))
        ));
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            normalizeCssStyles(utsArrayOf(
                styles0
            ), utsArrayOf(
                GenApp.styles
            ))
        };
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("index" to padStyleMapOf(utsMapOf("height" to "100%", "width" to "100%", "backgroundImage" to "linear-gradient(to bottom, #000000, #1A1A1A)", "backgroundColor" to "rgba(0,0,0,0)", "zIndex" to -1, "display" to "flex", "flexDirection" to "column", "alignItems" to "center", "justifyContent" to "center")), "menubox" to utsMapOf(".index " to utsMapOf("height" to "70%", "width" to "75%", "display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "alignItems" to "center", "borderRadius" to 15, "borderWidth" to 1, "borderStyle" to "solid", "borderColor" to "#1A1A1A")), "menubtn" to utsMapOf(".index .menubox " to utsMapOf("paddingTop" to 35, "borderRadius" to 35, "marginLeft" to 10, "marginRight" to 10, "height" to "90%", "borderWidth" to 3, "borderStyle" to "solid", "borderColor" to "#e91e63", "boxSizing" to "border-box", "flex" to 1)), "menutext" to utsMapOf(".index .menubox .menubtn .menunav " to utsMapOf("fontSize" to 30, "textAlign" to "center", "color" to "#e91e63", "fontFamily" to "像素字")), "menuimg" to utsMapOf(".index .menubox .menubtn .menunav " to utsMapOf("marginTop" to 10, "width" to "40%", "height" to "40%", "justifySelf" to "center", "alignSelf" to "center", "transform" to "translateX(-5%) translateY(3%) scale(1.05, 1.05)")), "menuimg2" to utsMapOf(".index .menubox .menubtn .menunav " to utsMapOf("marginTop" to 10, "width" to "40%", "height" to "40%", "transform" to "translateY(-2%) scale(0.85, 0.85)", "justifySelf" to "center", "alignSelf" to "center")), "menutitle" to padStyleMapOf(utsMapOf("transform" to "translateY(-25%) translateX(-3%)", "maxHeight" to 50, "fontSize" to 50, "textAlign" to "center", "color" to "#FFFFFF", "fontFamily" to "像素字")), "@FONT-FACE" to utsMapOf("0" to utsMapOf("fontFamily" to "像素字", "src" to "url(\"/assets/锐字太空奇遇像素.81d4f2f7.ttf\")")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
