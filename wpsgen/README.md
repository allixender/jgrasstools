- in main jgrasstools directory, standard maven build of all jgrasstools including the wps generator package
- skip test just so is faster :-)
- use the package directive to create a full (executable) jar of the wps generator

`mvn -Dmaven.test.skip=true clean package`

- go into the wpsgen subfolder
`cd wpsgen`

- call the generator class for your favourite WPS

`java -classpath target/jgt-zoowps-0.7.9-SNAPSHOT-jar-with-dependencies.jar org.jgrasstools.wps.utils.Generator52N`
`java -classpath target/jgt-zoowps-0.7.9-SNAPSHOT-jar-with-dependencies.jar org.jgrasstools.wps.utils.GeneratorZoo`

- now the classes have been genrated, you could check them in your IDE
- zoo config files should be generated under the src/main/resources folder
- now that the java classes are freshly generated in the build path, compile to see if all java is well

- go back up into main jgrasstools directory
`cd ..`
`mvn -Dmaven.test.skip=true compile`

- now package again, to vreate a full uber jar will all classes and all dependencies
`mvn -Dmaven.test.skip=true package`

- this single thing can be dropped into ZOO-Project cgi-bin folder or
- 52n wps/WEB-INF/lib and the the full canonical algorithm names to wps_config.xml (this step more docu later :-p )

http://localhost:8080/wps/WebProcessingService?service=WPS&version=1.0.0&request=execute&identifier=org.jgrasstools.wps.n52.RasterReprojectorAlgorithm&DataInputs=inRaster=/home/akmoch/dev/zoo-data/dtm.asc;pCode=EPSG:3003;pInterpolation=NEAREST_NEIGHTBOUR;outRaster=/home/akmoch/dev/zoo-data/dtm.out;pNorth=5110870.0;pSouth=5110830.0;pWest=1637140.0;pEast=1637190.0;pRows=4;pCols=5

- more docu and config files from my tests, need to look for them again :-)
- have a look at moovida/zoo-java-service-example and ZOO-Project Java API config
- the WPS processes in both ZOO-Project or 52N do not necessarily complete properly or even start properly
- the hardest challenge is really to generate the best matching with the parameter transfer between jgrasstools execution and WPS server

- as Jgrasstools mainly works on file system level, the file handling basically seems to be passing around pathnames as strings
- this should be relatively easy to implement, yet tricky to know which input parameter is also an output parameter

