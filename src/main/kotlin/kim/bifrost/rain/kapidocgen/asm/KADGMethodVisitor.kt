package kim.bifrost.rain.kapidocgen.asm

import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * kim.bifrost.rain.kapidocgen.asm.KADGMethodVisitor
 * KtorAPIDocGenerator-GradlePlugin
 *
 * @author 寒雨
 * @since 2022/5/3 2:27
 **/
class KADGMethodVisitor(
    private val methodVisitor: MethodVisitor,
    private val classVisitor: ClassVisitor
) : MethodVisitor(Opcodes.ASM7) {
    override fun visitMethodInsn(
        opcode: Int,
        owner: String?,
        name: String?,
        descriptor: String?,
        isInterface: Boolean
    ) {
        super.visitMethodInsn(opcode, owner, name, descriptor, isInterface)
    }
}