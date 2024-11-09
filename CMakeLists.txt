cmake_minimum_required(VERSION 3.20.0)
project(leetcode VERSION 0.1.0 LANGUAGES C CXX)

add_compile_options(-fstandalone-debug)
add_compile_options(-fno-limit-debug-info)
add_executable(leetcode src/product_except_self.cpp)

set(CPACK_PROJECT_NAME ${PROJECT_NAME})
set(CPACK_PROJECT_VERSION ${PROJECT_VERSION})
include(CPack)
