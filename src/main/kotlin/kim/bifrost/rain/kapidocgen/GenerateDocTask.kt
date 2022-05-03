package kim.bifrost.rain.kapidocgen

import groovyjarjarasm.asm.ClassReader
import groovyjarjarasm.asm.ClassWriter
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.TaskAction
import java.io.File
import java.util.jar.JarFile

/**
 * kim.bifrost.rain.kapidocgen.GenerateDocTask
 * KtorAPIDocGenerator-GradlePlugin
 *
 * @author 寒雨
 * @since 2022/5/3 1:21
 **/
class GenerateDocTask : DefaultTask() {
    @InputFile
    lateinit var inJar: File

    @TaskAction
    fun generate() {
        JarFile(inJar)
            .use { jarFile ->
                jarFile
                    .entries()
                    .asIterator()
                    .forEach {
                        // 存放顶级方法的文件
                        if (it.name.endsWith("Kt.class")) {
                            val type = it.name.replace("Kt.class", "")
                            jarFile.getInputStream(it).use { input ->
                                val classReader = ClassReader(input)

                            }
                        }
                    }
            }
    }
}