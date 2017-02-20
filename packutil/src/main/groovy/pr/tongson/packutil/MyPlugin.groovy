package pr.tongson.packutil

import com.android.build.gradle.api.ApplicationVariant
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.internal.DefaultDomainObjectSet

/**
 * build完成之后把apk文件拷贝到对应的位置的插件
 */
public class MyPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {

        System.out.println("========================");
        System.out.println("hello 插件!");

        project.afterEvaluate {
            // 重命名文件名
            if (project.getPlugins().hasPlugin(AppPlugin)) {
                DefaultDomainObjectSet<ApplicationVariant> variants = project.android.applicationVariants;
                BuildFileMoveExtension apkExtension = BuildFileMoveExtension.getConfig(project);
                String projectName = apkExtension.projectName;
                boolean isgm = apkExtension.isgm;
                if (projectName == null || projectName.trim().length() <= 0) {
                    return;
                }
                variants.all { variant ->
                    variant.outputs.each { output ->
                        if (output.outputFile != null && output.outputFile.name.endsWith(".apk")
                                && "patch_signed".equals(variant.buildType.name)) {
                            def buildTime = new Date().format("yyyy_MM_dd");
                            def apkname = projectName;
                            def flavor = variant.flavorName.toString();
                            if (flavor == null || flavor.trim().length() <= 0) {
                                flavor = "gm";
                            }

                            if (isgm) {
                                if (flavor == null || flavor.trim().length() <= 0) {
                                    flavor = "gm";
                                }
                            }

                            def apkFileName = "${buildTime}_${apkname}_V${variant.versionName}_${flavor}.apk";
                            def apkFile = new File(output.outputFile.getParent(), apkFileName);
                            output.outputFile = apkFile;
                        }
                    }
                }
            }
        }


















        System.out.println("========================");

    }
}