package org.abliger.asm.demo1;
import jdk.internal.org.objectweb.asm.*;

public class Gen implements Opcodes {
    public static byte[] dump() throws Exception {
        /*
        此处可以填三个值 0, ClassWriter.COMPUTE_MAXS 和 ClassWriter.COMPUTE_FRAMES
        0 手动计算操作数栈,局部变量表
        ClassWriter.COMPUTE_MAXS 自动计算操作数栈,局部变量表,但是必须要调用visitMaxs，方法参数会被忽略。桢变化需要手动计算
        ClassWriter.COMPUTE_FRAMES，全自动计算，但是必须要调用visitMaxs，方法参数会被忽略。
         */
        ClassWriter cw = new ClassWriter(0);
        FieldVisitor fv;
        MethodVisitor mv;
        AnnotationVisitor av0;
        // visit 方法 参数分别填 类的版本号 ,类的访问级别,类名,类的签名(泛型),超类名,接口名
        cw.visit(52, ACC_PUBLIC + ACC_SUPER, "org/abliger/asm/demo1/BBB", "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;Ljava/io/Serializable;", "java/util/HashMap", new String[]{"java/io/Serializable"});
        {
            // 生成注解 注意必须带L 或者使用type的getDescriptor方法
            av0 = cw.visitAnnotation(Type.getDescriptor(Target.class), true);
            // 设置注解的kv
            av0.visit("value", "df");
            av0.visitEnd();
        }
        // 进入BBB类
        cw.visitSource("BBB.java", null);

        {
            // 创建属性 str
            fv = cw.visitField(ACC_PUBLIC, "str", "Ljava/lang/String;", null, null);
            // 调用结束
            fv.visitEnd();
        }
        {
            // 创建属性 str
            fv = cw.visitField(ACC_PUBLIC + ACC_STATIC + ACC_FINAL, "str2", "Ljava/lang/String;", null, "first");
            // 调用结束
            fv.visitEnd();
        }
        {
            /*
            public getStr()Ljava/lang/String;
            L0
            LINENUMBER 13 L0
            ALOAD 0
            GETFIELD org/abliger/asm/demo1/BBB.str : Ljava/lang/String;
            ARETURN
            L1
            LOCALVARIABLE this Lorg/abliger/asm/demo1/BBB; L0 L1 0
            MAXSTACK = 1
            MAXLOCALS = 1
             */
            // 声明方法 填写方法的标识符,方法名,方法返回值,方法签名(泛型),抛出异常
            mv = cw.visitMethod(ACC_PUBLIC, "getStr", "()Ljava/lang/String;", null, null);
            // 填写方法体 根据java虚拟机的指令码填写asm
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitLineNumber(10, l0);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "org/abliger/asm/demo1/BBB", "str", "Ljava/lang/String;");
            mv.visitInsn(ARETURN);
            Label l1 = new Label();
            mv.visitLabel(l1);
            mv.visitLocalVariable("this", "Lorg/abliger/asm/demo1/aaa;", null, l0, l1, 0);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }
        {
            /*
              public setStr(Ljava/lang/String;)V
               L0
                LINENUMBER 17 L0
                ALOAD 0
                ALOAD 1
                PUTFIELD org/abliger/asm/demo1/BBB.str : Ljava/lang/String;
               L1
                LINENUMBER 18 L1
                RETURN
               L2
                LOCALVARIABLE this Lorg/abliger/asm/demo1/BBB; L0 L2 0
                LOCALVARIABLE str Ljava/lang/String; L0 L2 1
                MAXSTACK = 2
                MAXLOCALS = 2
             */
            mv = cw.visitMethod(ACC_PUBLIC, "setStr", "(Ljava/lang/String;)V", null, null);
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitLineNumber(14, l0);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitFieldInsn(PUTFIELD, "org/abliger/asm/demo1/BBB", "str", "Ljava/lang/String;");
            Label l1 = new Label();
            mv.visitLabel(l1);
            mv.visitLineNumber(15, l1);
            mv.visitInsn(RETURN);
            Label l2 = new Label();
            mv.visitLabel(l2);
            mv.visitLocalVariable("this", "Lorg/abliger/asm/demo1/BBB;", null, l0, l2, 0);
            mv.visitLocalVariable("str", "Ljava/lang/String;", null, l0, l2, 1);
            mv.visitMaxs(2, 2);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitLineNumber(16, l0);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, "java/util/HashMap", "<init>", "()V", false);
            Label l1 = new Label();
            mv.visitLabel(l1);
            mv.visitLineNumber(17, l1);
            mv.visitInsn(RETURN);
            Label l2 = new Label();
            mv.visitLabel(l2);
            mv.visitLocalVariable("this", "Lorg/abliger/asm/demo1/BBB;", null, l0, l2, 0);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "<init>", "(Ljava/lang/String;)V", null, null);
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitLineNumber(18, l0);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, "java/util/HashMap", "<init>", "()V", false);
            Label l1 = new Label();
            mv.visitLabel(l1);
            mv.visitLineNumber(19, l1);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitFieldInsn(PUTFIELD, "org/abliger/asm/demo1/BBB", "str", "Ljava/lang/String;");
            Label l2 = new Label();
            mv.visitLabel(l2);
            mv.visitLineNumber(20, l2);
            mv.visitInsn(RETURN);
            Label l3 = new Label();
            mv.visitLabel(l3);
            mv.visitLocalVariable("this", "Lorg/abliger/asm/demo1/BBB;", null, l0, l3, 0);
            mv.visitLocalVariable("aaa", "Ljava/lang/String;", null, l0, l3, 1);
            mv.visitMaxs(2, 2);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "print", "()V", null, null);
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitLineNumber(24, l0);
            mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn("test");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            Label l1 = new Label();
            mv.visitLabel(l1);
            mv.visitLineNumber(25, l1);
            mv.visitInsn(RETURN);
            Label l2 = new Label();
            mv.visitLabel(l2);
            mv.visitLocalVariable("this", "Lorg/abliger/asm/demo1/BBB;", null, l0, l2, 0);
            mv.visitMaxs(2, 1);
            mv.visitEnd();
        }
        cw.visitEnd();
        // 生成字节数组
        return cw.toByteArray();
    }

    public static byte[] dump1() throws Exception {
        /*
        此处可以填三个值 0, ClassWriter.COMPUTE_MAXS 和 ClassWriter.COMPUTE_FRAMES
        0 手动计算操作数栈,局部变量表
        ClassWriter.COMPUTE_MAXS 自动计算操作数栈,局部变量表,但是必须要调用visitMaxs，方法参数会被忽略。桢变化需要手动计算
        ClassWriter.COMPUTE_FRAMES，全自动计算，但是必须要调用visitMaxs，方法参数会被忽略。
         */
        ClassWriter cw = new ClassWriter(0);
        FieldVisitor fv;
        MethodVisitor mv;
        AnnotationVisitor av0;
        // visit 方法 参数分别填 类的版本号 ,类的访问级别,类名,类的签名(泛型),超类名,接口名
        cw.visit(52, ACC_PUBLIC + ACC_SUPER, "org/abliger/asm/demo1/BBB", "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;Ljava/io/Serializable;", "java/util/HashMap", new String[]{"java/io/Serializable"});
        {
            // 生成注解 注意必须带L 或者使用type的getDescriptor方法
            av0 = cw.visitAnnotation(Type.getDescriptor(Target.class), true);
            // 设置注解的kv
            av0.visit("value", "df");
            av0.visitEnd();
        }
        // 进入BBB类
        cw.visitSource("BBB.java", null);

        {
            // 创建属性 str
            fv = cw.visitField(ACC_PUBLIC, "str", "Ljava/lang/String;", null, null);
            // 调用结束
            fv.visitEnd();
        }
        {
            // 创建属性 str
            fv = cw.visitField(ACC_PUBLIC + ACC_STATIC + ACC_FINAL, "str2", "Ljava/lang/String;", null, "first");
            // 调用结束
            fv.visitEnd();
        }
        {
            /*
            public getStr()Ljava/lang/String;
            L0
            LINENUMBER 13 L0
            ALOAD 0
            GETFIELD org/abliger/asm/demo1/BBB.str : Ljava/lang/String;
            ARETURN
            L1
            LOCALVARIABLE this Lorg/abliger/asm/demo1/BBB; L0 L1 0
            MAXSTACK = 1
            MAXLOCALS = 1
             */
            // 声明方法 填写方法的标识符,方法名,方法返回值,方法签名(泛型),抛出异常
            mv = cw.visitMethod(ACC_PUBLIC, "getStr", "()Ljava/lang/String;", null, null);
            // 填写方法体 根据java虚拟机的指令码填写asm
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitLineNumber(10, l0);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "org/abliger/asm/demo1/BBB", "str", "Ljava/lang/String;");
            mv.visitInsn(ARETURN);
            Label l1 = new Label();
            mv.visitLabel(l1);
            mv.visitLocalVariable("this", "Lorg/abliger/asm/demo1/aaa;", null, l0, l1, 0);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }
        {
            /*
              public setStr(Ljava/lang/String;)V
               L0
                LINENUMBER 17 L0
                ALOAD 0
                ALOAD 1
                PUTFIELD org/abliger/asm/demo1/BBB.str : Ljava/lang/String;
               L1
                LINENUMBER 18 L1
                RETURN
               L2
                LOCALVARIABLE this Lorg/abliger/asm/demo1/BBB; L0 L2 0
                LOCALVARIABLE str Ljava/lang/String; L0 L2 1
                MAXSTACK = 2
                MAXLOCALS = 2
             */
            mv = cw.visitMethod(ACC_PUBLIC, "setStr", "(Ljava/lang/String;)V", null, null);
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitLineNumber(14, l0);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitFieldInsn(PUTFIELD, "org/abliger/asm/demo1/BBB", "str", "Ljava/lang/String;");
            Label l1 = new Label();
            mv.visitLabel(l1);
            mv.visitLineNumber(15, l1);
            mv.visitInsn(RETURN);
            Label l2 = new Label();
            mv.visitLabel(l2);
            mv.visitLocalVariable("this", "Lorg/abliger/asm/demo1/BBB;", null, l0, l2, 0);
            mv.visitLocalVariable("str", "Ljava/lang/String;", null, l0, l2, 1);
            mv.visitMaxs(2, 2);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitLineNumber(16, l0);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, "java/util/HashMap", "<init>", "()V", false);
            Label l1 = new Label();
            mv.visitLabel(l1);
            mv.visitLineNumber(17, l1);
            mv.visitInsn(RETURN);
            Label l2 = new Label();
            mv.visitLabel(l2);
            mv.visitLocalVariable("this", "Lorg/abliger/asm/demo1/BBB;", null, l0, l2, 0);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "<init>", "(Ljava/lang/String;)V", null, null);
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitLineNumber(18, l0);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, "java/util/HashMap", "<init>", "()V", false);
            Label l1 = new Label();
            mv.visitLabel(l1);
            mv.visitLineNumber(19, l1);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitFieldInsn(PUTFIELD, "org/abliger/asm/demo1/BBB", "str", "Ljava/lang/String;");
            Label l2 = new Label();
            mv.visitLabel(l2);
            mv.visitLineNumber(20, l2);
            mv.visitInsn(RETURN);
            Label l3 = new Label();
            mv.visitLabel(l3);
            mv.visitLocalVariable("this", "Lorg/abliger/asm/demo1/BBB;", null, l0, l3, 0);
            mv.visitLocalVariable("aaa", "Ljava/lang/String;", null, l0, l3, 1);
            mv.visitMaxs(2, 2);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "print", "()V", null, null);
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitLineNumber(24, l0);
            mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn("test");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            Label l1 = new Label();
            mv.visitLabel(l1);
            mv.visitLineNumber(25, l1);
            mv.visitInsn(RETURN);
            Label l2 = new Label();
            mv.visitLabel(l2);
            mv.visitLocalVariable("this", "Lorg/abliger/asm/demo1/BBB;", null, l0, l2, 0);
            mv.visitMaxs(2, 1);
            mv.visitEnd();
        }
        cw.visitEnd();
        ClassReader classReader = new ClassReader("org.abliger.asm.demo1.Source");
//        classReader.accept(cw,ClassReader.SKIP_DEBUG);

        ClassVisitor classVisitor = new ClassVisitor(ASM5, cw) {
            @Override
            public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
                System.out.println(name);
                if (name.contains("ooo")) {
                    return null;
                }
                return this.cv.visitMethod(access, name, desc, signature, exceptions);
            }
        };
        classReader.accept(classVisitor, ClassReader.SKIP_DEBUG);
        // 生成字节数组
        return cw.toByteArray();
    }
}
