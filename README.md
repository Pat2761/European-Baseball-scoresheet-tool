# European Baseball scoresheet tool

you can find the french version of this document [here](README_fr.md)

Today, there are numerous software solutions available for entering and editing baseball scorecards. However, these tools are primarily designed based on American practices and do not necessarily account for the specific requirements of European-style scoring.

European scoring has its own rules and notation conventions, which must be followed to ensure that match sheets are compliant and the resulting statistics are consistent.

**The objective of this project is to provide a software solution tailored to the European scoring system**, enabling the entry, management, and generation of scorecards in accordance with European practices.
It thus aims to offer scorers, clubs, and those involved in European baseball a tool that addresses their specific needs.

## Software overview

This application is based on a language designed to describe the various actions that occur during a baseball game. To this end, the application includes a tool for editing the rosters of teams participating in a championship, as well as a second editor for documenting every action within a game. The application is structured as follows:

![Graphical Interface](docs/FullView.jpg)

This application contains several views, primarily:
-	The editing area
-	A window for viewing errors or warnings regarding the information entered
-	An infield view showing player names and positions
-	The active lineup
-	A project manager
-	A scoreboard
-	A graphical view (a real-time representation of the score sheet)

Once the match data has been entered, the score sheets can be exported in PDF format.
Instructions for using the software can be found in the help section, accessible via the "Help" menu. This section includes both the application's user manual and a scoring manual written by Anna Maria PAINI.

The application also allows you to import the 2019 D1 championship data, which can serve as a helpful resource for understanding how the application works.

## Installation/Usage

This software is provided as a ZIP file, which you should extract into a directory of your choice. To launch the application, you can create a desktop shortcut pointing to the file EuropeanScoreTool.exe.

## Building for Developers

If you wish to rebuild this application, you must use Maven. The build process consists of two steps:
-	In the "org.bpy.socre.build" project, execute "Run As" > "Maven install" on the pom.xml file.
-	In the "org.bpy.score.project" project, execute "Run As" > "Maven install" on the pom.xml file.
-	The application will then be available in the "target" directory—specifically under "org.bpy.score.product\target\products"—as a ZIP file. The filename follows this format: "ScoreKepperTool_x.x.x-SNAPSHOT.zip".

## Technologies Used
Here are the main tools used:

| Tool | Description |
| :----- | :----- |
| Java | Java 17 |
| Edition | Eclipse 2023-06 (DSL Developer version) |
| Build | Maven |

List of plugins used in Eclipse:

| Technology | Description |
| :----- | :----- |
| WindowBuilder | Graphical user interface (GUI) editor |
| SonarLint | Code quality analysis |
| Xtext | Definition of the two editors |
| Git | Configuration management |

Languages ​​used:

| Technology | Description |
| :----- | :----- |
| Java | Application code |
| Xtend | Unit testing |
| Xtext | Definition of the editor language |
| Markdown | This documentation |
| HTML | Application help/documentation |
| XML | Project description files |

## License
This software is licensed under the GPL-3.0 license. This means you are free to use it and access the source code to make improvements (it would be great if you shared those improvements with me!), but you are not permitted to use it for commercial purposes without my authorization.

## Limitations
This software is still under development, so there are some limitations to its use:
- Report generation is not yet complete.
- The software does not account for rules specific to softball.
- The software does not handle additional score sheets in cases where there are more than 12 innings or an excessive number of substitutions.
- There are a few known issues that have not yet been resolved.

## Contact / Author
If you would like to report any malfunctions, you have two options:
- Open an issue on GitHub, providing as much detail as possible about the problem you encountered.
- Send an email to: briand.patrick [at] free.fr

## Versions