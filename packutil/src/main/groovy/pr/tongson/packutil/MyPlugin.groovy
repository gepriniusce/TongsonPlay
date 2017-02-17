package pr.tongson.packutil

import org.gradle.api.Plugin
import org.gradle.api.Project
/**
 * build完成之后把apk文件拷贝到对应的位置的插件
 */
public class MyPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {

        System.out.println("========================");
        System.out.println("hello 插件!");
        System.out.println("========================");

    }
}