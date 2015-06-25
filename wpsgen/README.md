# in main jgrasstools directory, standard maven build of all jgrasstools including the wps generator package
i# skip test just so is faster :-)
# use the package directive to create a full (executable) jar of the wps generator
mvn -Dmaven.test.skip=true clean package

# go into the wpsgen subfolder
cd wpsgen

# call the generator class for your favourite WPS

java -classpath target/jgt-zoowps-0.7.9-SNAPSHOT-jar-with-dependencies.jar org.jgrasstools.wps.utils.Generator52N
java -classpath target/jgt-zoowps-0.7.9-SNAPSHOT-jar-with-dependencies.jar org.jgrasstools.wps.utils.GeneratorZoo

# now the classes have been genrated, you could check them in your IDE
# zoo config files should be generated under the src/main/resources folder
#
# now that the java classes are freshly generated in the build path, compile to see if all java is well

mvn -Dmaven.test.skip=true compile

# now package again, to vreate a full uber jar will all classes and all dependencies
mvn -Dmaven.test.skip=true package

# this single thing can be dropped in
# 52n wps/WEB-INF/lib and the the full canonical algorithm names to wps_config.xml (this step more docu later :-p )

http://localhost:8080/wps/WebProcessingService?service=WPS&version=1.0.0&request=execute&identifier=org.jgrasstools.wps.n52.RasterReprojectorAlgorithm&DataInputs=inRaster=/home/akmoch/dev/zoo-data/dtm.asc;pCode=EPSG:3003;pInterpolation=NEAREST_NEIGHTBOUR;outRaster=/home/akmoch/dev/zoo-data/dtm.out;pNorth=5110870.0;pSouth=5110830.0;pWest=1637140.0;pEast=1637190.0;pRows=4;pCols=5


# similarly in ZOO-Project
.. more docu and config files from my tests, need to look for them again :-)

# have a look at moovida/java-zoo-service-example and ZOO-Project Java API config

