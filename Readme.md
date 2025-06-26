## Records in java
Why - no need of constructor,getter,setter
immutable

## Lombok
Hooks into javac to inject code at compile time. 

## Maven
BOM / <dependencyManagement> lets you declare dependencies without version; versions come from the parent POM.

Plugin configs are not managed by the BOM, so annotationProcessorPaths (lombok) entries need explicit versions.

Without a specified Lombok version in the compiler plugin, Maven skips Lombok’s annotation processor and does not generate the log field.

## Loggers vs Appenders
a logger is the interface for sending log messages, 
and an appender defines where those messages are delivered — such as a console, file, or remote service.

### 🔁 RollingFileAppender vs FileAppender (Quick Revision)

* **FileAppender**: Writes to a single log file → grows indefinitely → ❌ not production-friendly

* **RollingFileAppender**:

    * ✅ **Performs log file Rotation**: ie Automatically creates a new log file based on size or time
    * ✅ **Size-based rotation** (e.g., after 10MB)
    * ✅ **Time-based rotation** (daily, hourly, etc.)
    * ✅ **Retention**: `maxHistory` (e.g., keep 7 days)
    * ✅ **Storage cap**: `totalSizeCap` (e.g., 1GB)
    * 📁 Archives logs as `app-YYYY-MM-DD.log`

➡️ Always prefer `RollingFileAppender` in production for clean, manageable logs.

:
🧵 What is an AsyncAppender?
The AsyncAppender is a non-blocking logging appender that buffers log events in a separate thread before passing them to the actual appender (like a FileAppender or RollingFileAppender).
it holds a reference to the actual appender ( file, console etc) and forwards log events to it asynchronously.


# HTTP Status Codes
### 400 means request is reaching your controller, but JSON ↔️ Java conversion failed.
### 500 means something went wrong in your code, like a NullPointerException or an unhandled exception.
### 404 means the requested resource was not found, like a missing endpoint or incorrect URL.
### 200 means everything is fine, and the request was successful.



   