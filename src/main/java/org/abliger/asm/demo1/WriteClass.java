package org.abliger.asm.demo1;

import com.sun.xml.internal.ws.org.objectweb.asm.Type;
import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class WriteClass {
    /***
     * A visitor to visit a Java class. The methods of this class must be called in
     * the following order: <tt>visit</tt> [ <tt>visitSource</tt> ] [
     * <tt>visitOuterClass</tt> ] ( <tt>visitAnnotation</tt> |
     * <tt>visitTypeAnnotation</tt> | <tt>visitAttribute</tt> )* (
     * <tt>visitInnerClass</tt> | <tt>visitField</tt> | <tt>visitMethod</tt> )*
     * <tt>visitEnd</tt>.
     */
    public static void main(String[] args) throws IOException {
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        classWriter.visit(Opcodes.V1_8,Opcodes.ACC_PUBLIC,"AsmWriterTest",null,null,null);
        // 注意：access必须是 static final,否则value不会进行赋值
        classWriter.visitField(Opcodes.ACC_PUBLIC+Opcodes.ACC_STATIC+Opcodes.ACC_FINAL,"one",Type.getDescriptor(String.class),"aaaaa","abliger");
        classWriter.visitEnd();
        byte[] bytes = classWriter.toByteArray();
        Files.write(Paths.get("./target/org/abliger/asm/demo1/AsmWriterTest.class"),bytes);
    }
}
