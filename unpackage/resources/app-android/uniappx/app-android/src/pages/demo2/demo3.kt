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
import io.dcloud.uniapp.extapi.getStorageSync as uni_getStorageSync;
import io.dcloud.uniapp.extapi.setStorageSync as uni_setStorageSync;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
open class GenPagesDemo2Demo3 : BasePage {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesDemo2Demo3) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!;
            val _ctx = __ins.proxy as GenPagesDemo2Demo3;
            val _cache = __ins.renderCache;
            var addword = ref("");
            var list = uni_getStorageSync("wordList") as UTSArray<String>;
            var wordList = ref(list);
            console.log(list);
            fun genAddFn(word: String) {
                wordList.value.push(word);
                uni_setStorageSync("wordList", wordList.value);
                uni_showToast(ShowToastOptions(title = "添加成功", icon = "none", position = "bottom"));
            }
            val add = ::genAddFn;
            fun genDelFn(index: Number) {
                wordList.value.splice(index, 1);
            }
            val del = ::genDelFn;
            fun genSaveFn() {
                uni_setStorageSync("wordList", wordList.value);
                console.log("保存成功");
                uni_showToast(ShowToastOptions(title = "保存成功", icon = "none", position = "bottom"));
            }
            val save = ::genSaveFn;
            return fun(): Any? {
                val _component_navigator = resolveComponent("navigator");
                return createElementVNode("view", utsMapOf("class" to "demo3"), utsArrayOf(
                    createVNode(_component_navigator, utsMapOf("open-type" to "reLaunch", "url" to "/pages/index/index", "class" to "Exit"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            createElementVNode("text", utsMapOf("selectable" to "false", "class" to "ExitText"), "< 返回")
                        );
                    }
                    ), "_" to 1)),
                    createElementVNode("scroll-view", utsMapOf("class" to "showscrollview", "scroll-y" to "true"), utsArrayOf(
                        createElementVNode(Fragment, null, RenderHelpers.renderList(unref(wordList), fun(item, index, __index, _cached): Any {
                            return createElementVNode("view", utsMapOf("class" to "showview"), utsArrayOf(
                                createElementVNode("text", utsMapOf("class" to "textbox"), toDisplayString(item), 1),
                                createElementVNode("text", utsMapOf("class" to "textboxdel", "onClick" to fun(){
                                    del(index);
                                }
                                ), " 删除 ", 8, utsArrayOf(
                                    "onClick"
                                ))
                            ));
                        }
                        ), 256)
                    )),
                    createElementVNode("view", utsMapOf("class" to "inputbox"), utsArrayOf(
                        createElementVNode("input", utsMapOf("class" to "showinput", "placeholder" to "请输入添加的内容", "modelValue" to unref(addword), "onInput" to fun(`$event`: InputEvent){
                            addword = trySetRefValue(addword, `$event`.detail.value);
                        }
                        ), null, 40, utsArrayOf(
                            "modelValue"
                        )),
                        createElementVNode("button", utsMapOf("class" to "subbtn", "onClick" to fun(){
                            add(unref(addword));
                        }
                        ), "添加", 8, utsArrayOf(
                            "onClick"
                        ))
                    )),
                    createElementVNode("view", utsMapOf("class" to "Save", "onClick" to fun(){
                        save();
                    }
                    ), utsArrayOf(
                        createElementVNode("text", utsMapOf("class" to "SaveText"), "保存")
                    ), 8, utsArrayOf(
                        "onClick"
                    ))
                ));
            }
            ;
        }
        ;
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            normalizeCssStyles(utsArrayOf(
                styles0
            ), utsArrayOf(
                GenApp.styles
            ))
        };
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("demo3" to padStyleMapOf(utsMapOf("height" to "100%", "width" to "100%", "backgroundImage" to "linear-gradient(to bottom, #000000, #1A1A1A)", "backgroundColor" to "rgba(0,0,0,0)", "display" to "flex", "alignItems" to "center", "justifyContent" to "center", "zIndex" to -1)), "Exit" to utsMapOf(".demo3 " to utsMapOf("zIndex" to 200, "position" to "fixed", "marginLeft" to "5%", "marginTop" to "3%", "width" to 100, "height" to 50)), "ExitText" to utsMapOf(".demo3 .Exit " to utsMapOf("fontFamily" to "像素字", "color" to "#FFFFFF", "fontSize" to 30, "textAlign" to "left")), "Save" to utsMapOf(".demo3 " to utsMapOf("zIndex" to 200, "position" to "fixed", "right" to "10%", "marginTop" to "3%", "width" to 100, "height" to 50)), "SaveText" to utsMapOf(".demo3 .Save " to utsMapOf("fontFamily" to "像素字", "color" to "#FFFFFF", "fontSize" to 30, "textAlign" to "center")), "showview" to utsMapOf(".demo3 " to utsMapOf("borderBottomWidth" to 2, "borderBottomStyle" to "solid", "borderBottomColor" to "#1A1A1A", "width" to "100%", "backgroundColor" to "#FFFFFF", "display" to "flex", "flexDirection" to "row", "position" to "relative")), "textbox" to utsMapOf(".demo3 .showview " to utsMapOf("flex" to 1, "textAlign" to "left", "fontFamily" to "像素字", "fontSize" to 35)), "textboxdel" to utsMapOf(".demo3 .showview " to utsMapOf("borderLeftWidth" to 2, "borderLeftStyle" to "solid", "borderLeftColor" to "#000000", "textAlign" to "right", "fontFamily" to "像素字", "fontSize" to 35, "color" to "#FF0000")), "showscrollview" to utsMapOf(".demo3 " to utsMapOf("marginTop" to "5%", "height" to "55%", "width" to "75%", "backgroundColor" to "#FFFFFF", "position" to "relative")), "inputbox" to utsMapOf(".demo3 " to utsMapOf("marginTop" to "3%", "width" to "75%", "display" to "flex", "flexDirection" to "row", "height" to 60)), "showinput" to utsMapOf(".demo3 .inputbox " to utsMapOf("height" to "100%", "width" to "84%", "marginRight" to "2%", "textAlign" to "left", "backgroundColor" to "#F5DEB3", "fontFamily" to "像素字")), "subbtn" to utsMapOf(".demo3 .inputbox " to utsMapOf("fontFamily" to "像素字", "height" to "100%", "width" to "15%", "backgroundColor" to "#0000FF", "paddingTop" to 7, "paddingRight" to 7, "paddingBottom" to 7, "paddingLeft" to 7, "color" to "#FFFFFF", "boxSizing" to "border-box")), "@FONT-FACE" to utsMapOf("0" to utsMapOf("fontFamily" to "像素字", "src" to "url(\"/assets/锐字太空奇遇像素.81d4f2f7.ttf\")")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
