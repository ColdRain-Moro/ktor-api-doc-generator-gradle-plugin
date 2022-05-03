package kim.bifrost.rain.kapidocgen

import org.gradle.api.Plugin
import org.gradle.api.Project


/**
 * kim.bifrost.rain.kapidocgen.KApiDocGenPlugin
 * KtorAPIDocGenerator-GradlePlugin
 *
 * @author 寒雨
 * @since 2022/5/3 1:14
 **/
class KApiDocGenPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.extensions.create("environments", KApiDocGenExtension::class.java)
        project.tasks.register("generateDocData", GenerateDocTask::class.java)
    }
}