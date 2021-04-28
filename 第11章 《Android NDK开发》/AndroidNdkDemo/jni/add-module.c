#include <jni.h>

jlong Java_edu_hrbeu_AndroidNdkDemo_AndroidNdkDemoActivity_add( JNIEnv*  env,
                                      jobject  this,
                                      jlong     x,
                                      jlong     y )
{
   return x+y;
}
