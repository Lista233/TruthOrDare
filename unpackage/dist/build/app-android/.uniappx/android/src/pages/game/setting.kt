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
import io.dcloud.uniapp.extapi.createInnerAudioContext as uni_createInnerAudioContext;
import io.dcloud.uniapp.extapi.getStorageInfoSync as uni_getStorageInfoSync;
import io.dcloud.uniapp.extapi.getStorageSync as uni_getStorageSync;
import io.dcloud.uniapp.extapi.setStorageSync as uni_setStorageSync;
import io.dcloud.uniapp.extapi.showActionSheet as uni_showActionSheet;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
open class GenPagesGameSetting : BasePage {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesGameSetting) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!;
            val _ctx = __ins.proxy as GenPagesGameSetting;
            val _cache = __ins.renderCache;
            var keylist = uni_getStorageInfoSync().keys;
            var curshow = ref(keylist[0]);
            var list = uni_getStorageSync(curshow.value) as UTSArray<String>;
            var wordList = ref(list);
            var addword = ref("");
            var audio = uni_createInnerAudioContext();
            fun genChangewordFn(res: UniInputConfirmEvent, index: Number) {
                wordList.value[index] = res.detail.value;
                uni_setStorageSync(curshow.value, wordList.value);
                uni_showToast(ShowToastOptions(title = "修改成功", icon = "none", position = "bottom"));
            }
            val changeword = ::genChangewordFn;
            fun genAddFn(word: String) {
                if (word.trim().length === 0) {
                    uni_showToast(ShowToastOptions(title = "输入内容不能为空", icon = "none", position = "bottom"));
                    return;
                }
                wordList.value.push(word);
                uni_setStorageSync(curshow.value, wordList.value);
                uni_showToast(ShowToastOptions(title = "添加成功", icon = "none", position = "bottom"));
                addword.value = "";
            }
            val add = ::genAddFn;
            fun genDelFn(index: Number) {
                wordList.value.splice(index, 1);
                uni_showToast(ShowToastOptions(title = "为防止误删，保存后删除生效", icon = "none", position = "bottom"));
            }
            val del = ::genDelFn;
            fun genSaveFn() {
                uni_setStorageSync(curshow.value, wordList.value);
                console.log("保存成功");
                uni_showToast(ShowToastOptions(title = "保存成功", icon = "none", position = "bottom"));
            }
            val save = ::genSaveFn;
            fun genShowListFn() {
                var op = ShowActionSheetOptions(itemList = keylist, success = fun(res){
                    curshow.value = keylist[res.tapIndex!!];
                    wordList.value = uni_getStorageSync(curshow.value) as UTSArray<String>;
                }
                );
                uni_showActionSheet(op);
            }
            val showList = ::genShowListFn;
            return fun(): Any? {
                val _component_navigator = resolveComponent("navigator");
                return createElementVNode("view", utsMapOf("class" to "demo3"), utsArrayOf(
                    createVNode(_component_navigator, utsMapOf("open-type" to "navigateBack", "animation-type" to "pop-out", "url" to "/pages/index/index", "class" to "Exit"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            createElementVNode("text", utsMapOf("selectable" to "false", "class" to "ExitText"), "< 返回")
                        );
                    }
                    ), "_" to 1)),
                    createElementVNode("scroll-view", utsMapOf("class" to "showscrollview", "scroll-y" to "true"), utsArrayOf(
                        createElementVNode(Fragment, null, RenderHelpers.renderList(unref(wordList), fun(item, index, __index, _cached): Any {
                            return createElementVNode("view", utsMapOf("class" to "showview"), utsArrayOf(
                                createElementVNode("input", utsMapOf("class" to "textbox", "value" to item, "onInput" to fun(res: UniInputConfirmEvent){
                                    return changeword(res, index);
                                }
                                ), null, 40, utsArrayOf(
                                    "value",
                                    "onInput"
                                )),
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
                        , "adjust-position" to "true"), null, 40, utsArrayOf(
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
                    )),
                    createElementVNode("view", utsMapOf("class" to "sel", "onClick" to fun(){
                        showList();
                    }
                    ), utsArrayOf(
                        createElementVNode("text", utsMapOf("class" to "selText"), "当前列表:" + toDisplayString(unref(curshow)), 1)
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
                return utsMapOf("demo3" to padStyleMapOf(utsMapOf("height" to "100%", "width" to "100%", "backgroundImage" to "linear-gradient(to bottom, #000000, #1A1A1A)", "backgroundColor" to "rgba(0,0,0,0)", "display" to "flex", "alignItems" to "center", "justifyContent" to "center", "zIndex" to -1)), "Exit" to utsMapOf(".demo3 " to utsMapOf("zIndex" to 200, "position" to "fixed", "marginLeft" to "5%", "marginTop" to "3%", "width" to 100, "height" to 50)), "ExitText" to utsMapOf(".demo3 .Exit " to utsMapOf("fontFamily" to "像素字", "color" to "#FFFFFF", "fontSize" to 30, "textAlign" to "left")), "Save" to utsMapOf(".demo3 " to utsMapOf("zIndex" to 1, "position" to "fixed", "right" to "8%", "marginTop" to "3%", "width" to 100, "height" to 50)), "SaveText" to utsMapOf(".demo3 .Save " to utsMapOf("fontFamily" to "像素字", "color" to "#FFFFFF", "fontSize" to 30, "textAlign" to "center")), "sel" to utsMapOf(".demo3 " to utsMapOf("zIndex" to 1, "position" to "fixed", "right" to "35%", "marginTop" to "3%", "width" to 300, "height" to 50)), "selText" to utsMapOf(".demo3 .sel " to utsMapOf("fontFamily" to "像素字", "color" to "#FFFFFF", "fontSize" to 30, "textAlign" to "center")), "showview" to utsMapOf(".demo3 " to utsMapOf("borderBottomWidth" to 2, "borderBottomStyle" to "solid", "borderBottomColor" to "#1A1A1A", "width" to "100%", "backgroundColor" to "#FFFFFF", "display" to "flex", "flexDirection" to "row", "position" to "relative")), "textbox" to utsMapOf(".demo3 .showview " to utsMapOf("flex" to 1, "textAlign" to "left", "fontFamily" to "像素字", "fontSize" to 25)), "textboxdel" to utsMapOf(".demo3 .showview " to utsMapOf("borderLeftWidth" to 2, "borderLeftStyle" to "solid", "borderLeftColor" to "#000000", "textAlign" to "right", "fontFamily" to "像素字", "fontSize" to 30, "color" to "#FF0000")), "showscrollview" to utsMapOf(".demo3 " to utsMapOf("marginTop" to "5%", "height" to "57%", "width" to "80%", "backgroundColor" to "#FFFFFF", "position" to "relative")), "inputbox" to utsMapOf(".demo3 " to utsMapOf("marginTop" to "3%", "width" to "80%", "display" to "flex", "flexDirection" to "row", "height" to 60)), "showinput" to utsMapOf(".demo3 .inputbox " to utsMapOf("height" to "100%", "width" to "84%", "marginRight" to "2%", "textAlign" to "left", "backgroundColor" to "#F5DEB3", "fontFamily" to "像素字")), "subbtn" to utsMapOf(".demo3 .inputbox " to utsMapOf("fontFamily" to "像素字", "height" to "100%", "width" to "15%", "backgroundColor" to "#0000FF", "paddingTop" to 7, "paddingRight" to 7, "paddingBottom" to 7, "paddingLeft" to 7, "color" to "#FFFFFF", "boxSizing" to "border-box")), "@FONT-FACE" to utsMapOf("0" to utsMapOf("fontFamily" to "像素字", "src" to "url(\"../static/锐字太空奇遇像素.ttf\")")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
