package kim.bifrost.rain.kapidocgen

import groovyjarjarasm.asm.ClassReader
import javassist.bytecode.ClassFile
import kim.bifrost.rain.kapidocgen.data.ApiData
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.TaskAction
import java.io.DataInputStream
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

    val apis = mutableMapOf<String, List<ApiData>>()

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
                                val classFile = ClassFile(DataInputStream(input))
                                val apiMethods = classFile.methods
                                    .filter { m -> m.descriptor == "(Lio/ktor/routing/Routing;)V" }
                                apiMethods.forEach { info ->
                                    val iter = info.codeAttribute
                                        .iterator()
                                    while (iter.hasNext()) {
                                        iter.next()
                                    }
                                }
                            }
                        }
                    }
            }
    }
}