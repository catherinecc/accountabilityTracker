## Records in java
Why - no need of constructor,getter,setter
immutable

## Lombok
Hooks into javac to inject code at compile time. 

## Maven
BOM / <dependencyManagement> lets you declare dependencies without version; versions come from the parent POM.

Plugin configs are not managed by the BOM, so annotationProcessorPaths (lombok) entries need explicit versions.

Without a specified Lombok version in the compiler plugin, Maven skips Lombok’s annotation processor and does not generate the log field.

e