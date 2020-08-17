package metautils.codegeneration.asm

import metautils.types.JvmPrimitiveTypes
import metautils.types.JvmReturnType
import metautils.types.ObjectType
import metautils.types.VoidJvmReturnType
import metautils.util.toSlashString

fun ObjectType.toJvmString() = fullClassName.toSlashString()
fun JvmReturnType.toJvmString() = if (this is ObjectType) toJvmString() else classFileName
fun JvmReturnType.isTwoBytesWide() = this == JvmPrimitiveTypes.Long || this == JvmPrimitiveTypes.Double
fun JvmReturnType.byteWidth() = when {
    this == VoidJvmReturnType -> 0
    isTwoBytesWide() -> 2
    else -> 1
}
