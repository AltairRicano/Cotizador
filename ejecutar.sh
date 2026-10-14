#!/usr/bin/env bash
# Compila el programa (src/main) y las pruebas (src/test) y corre todas con JUnit 5,
# mostrando el árbol completo, el detalle de cada fallo y el resumen final.
# Uso: ./ejecutar.sh            (todas las pruebas)
#      ./ejecutar.sh CP05       (sólo las pruebas cuyo nombre contiene CP05)
set -e
cd "$(dirname "$0")"
JAR=../lib/junit-platform-console-standalone.jar
rm -rf out && mkdir out
javac -encoding UTF-8 -d out -cp "$JAR" src/main/java/uv/lis/pruebas/*.java src/test/java/uv/lis/pruebas/*.java
FILTRO=()
[ -n "$1" ] && FILTRO=(--include-methodname ".*$1.*")
java -jar "$JAR" execute --class-path out --scan-class-path --disable-banner \
  --details=tree --details-theme=ascii --disable-ansi-colors "${FILTRO[@]}" || true
