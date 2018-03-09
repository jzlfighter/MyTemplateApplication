
cmake_minimum_required(VERSION 3.4.1)

add_library(native-lib-test
SHARED
src/main/cpp/jni-bridge.cpp
src/main/cpp/Oscillator.cpp
src/main/cpp/AudioEngine.cpp)

find_library( # Sets the name of the path variable.
              log-lib

              # Specifies the name of the NDK library that
              # you want CMake to locate.
              log )

target_link_libraries( # Specifies the target library.
                                     native-lib-test
aaudio
                                     # Links the target library to the log library
                                     # included in the NDK.
                                     ${log-lib} )
