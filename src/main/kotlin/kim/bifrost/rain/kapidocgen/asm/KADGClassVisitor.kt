package kim.bifrost.rain.kapidocgen.asm

import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * kim.bifrost.rain.kapidocgen.asm.KADGClassVisitor
 * KtorAPIDocGenerator-GradlePlugin
 *
 * @author 寒雨
 * @since 2022/5/3 2:24
 **/
class KADGClassVisitor : ClassVisitor(Opcodes.ASM7) {
    override fun visitMethod(
        access: Int,
        name: String?,
        descriptor: String?,
        signature: String?,
        exceptions: Array<out String>?
    ): MethodVisitor {
        return KADGMethodVisitor(super.visitMethod(access, name, descriptor, signature, exceptions), this)
    }
}