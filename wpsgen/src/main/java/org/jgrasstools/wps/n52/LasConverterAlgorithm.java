/* THIS FILE IS GENERATED, DO NOT EDIT, IT WILL BE OVERWRITTEN */
package org.jgrasstools.wps.n52; 
 
import java.util.Collection; 
import java.util.HashMap; 
import java.util.ArrayList; 
import java.util.List; 
import java.io.*; 
 
import oms3.Access; 
import oms3.ComponentAccess; 
import oms3.annotations.Execute; 
import oms3.annotations.Finalize; 
import oms3.annotations.Initialize; 
 
import org.n52.wps.server.AbstractAnnotatedAlgorithm;
import org.n52.wps.algorithm.annotation.*; 
 
import org.n52.wps.io.data.binding.literal.*; 
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 
 
import org.geotools.process.ProcessException; 
import org.jgrasstools.modules.LasConverter; 
 
@Algorithm(version = "1.0.0", abstrakt = "Coverter from LAS to vector point data.")
public class LasConverterAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(LasConverterAlgorithm.class); 

  public LasConverterAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String infile;

  @LiteralDataInput(identifier = "inFile", abstrakt = "The LAS file.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinFile(String infile) { 
    this.infile = infile;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inpolygons;

  @LiteralDataInput(identifier = "inPolygons", abstrakt = "A vector map of polygons to filter the data on.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinPolygons(String inpolygons) { 
    this.inpolygons = inpolygons;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String pintensityrange;

  @LiteralDataInput(identifier = "pIntensityrange", abstrakt = "The (min, max) range inside which the values should be taken.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setpIntensityrange(String pintensityrange) { 
    this.pintensityrange = pintensityrange;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String pimpulses;

  @LiteralDataInput(identifier = "pImpulses", abstrakt = "The comma separated list of impulses values to keep.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setpImpulses(String pimpulses) { 
    this.pimpulses = pimpulses;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String pclasses;

  @LiteralDataInput(identifier = "pClasses", abstrakt = "The comma separated list of classes to keep.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setpClasses(String pclasses) { 
    this.pclasses = pclasses;
  }

    // inputOutputIndicator = input
    // fileIndicator = process_north
    // fieldType = Double
    // fieldBindingType = Double
    // fieldVariableType = Double
  private Double pnorth;

  @LiteralDataInput(identifier = "pNorth", abstrakt = "The optional requested boundary north coordinate.", minOccurs = 0, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpNorth(Double pnorth) { 
    this.pnorth = pnorth;
  }

    // inputOutputIndicator = input
    // fileIndicator = process_south
    // fieldType = Double
    // fieldBindingType = Double
    // fieldVariableType = Double
  private Double psouth;

  @LiteralDataInput(identifier = "pSouth", abstrakt = "The optional requested boundary south coordinate.", minOccurs = 0, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpSouth(Double psouth) { 
    this.psouth = psouth;
  }

    // inputOutputIndicator = input
    // fileIndicator = process_west
    // fieldType = Double
    // fieldBindingType = Double
    // fieldVariableType = Double
  private Double pwest;

  @LiteralDataInput(identifier = "pWest", abstrakt = "The optional requested boundary west coordinate.", minOccurs = 0, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpWest(Double pwest) { 
    this.pwest = pwest;
  }

    // inputOutputIndicator = input
    // fileIndicator = process_east
    // fieldType = Double
    // fieldBindingType = Double
    // fieldVariableType = Double
  private Double peast;

  @LiteralDataInput(identifier = "pEast", abstrakt = "The optional requested boundary east coordinate.", minOccurs = 0, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpEast(Double peast) { 
    this.peast = peast;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = boolean
    // fieldBindingType = Boolean
    // fieldVariableType = Boolean
  private Boolean doheader;

  @LiteralDataInput(identifier = "doHeader", abstrakt = "Only print header and exit (default is false).", minOccurs = 1, maxOccurs = 1, binding = LiteralBooleanBinding.class)
  public void setdoHeader(Boolean doheader) { 
    this.doheader = doheader;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = boolean
    // fieldBindingType = Boolean
    // fieldVariableType = Boolean
  private Boolean doinfo;

  @LiteralDataInput(identifier = "doInfo", abstrakt = "Print additional info and exit (default is false).", minOccurs = 1, maxOccurs = 1, binding = LiteralBooleanBinding.class)
  public void setdoInfo(Boolean doinfo) { 
    this.doinfo = doinfo;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = boolean
    // fieldBindingType = Boolean
    // fieldVariableType = Boolean
  private Boolean dobbox;

  @LiteralDataInput(identifier = "doBbox", abstrakt = "Generate a bounding box polygon as output vector (default is false).", minOccurs = 1, maxOccurs = 1, binding = LiteralBooleanBinding.class)
  public void setdoBbox(Boolean dobbox) { 
    this.dobbox = dobbox;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outfile;

  @LiteralDataInput(identifier = "outFile", abstrakt = "The output file (csv, shp, las).", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutFile(String outfile) { 
    this.outfile = outfile;
  }

  private String res_outfile;

  @LiteralDataOutput(identifier = "res_outFile", abstrakt = "The output file (csv, shp, las).", binding = LiteralStringBinding.class)
  public String getRes_outFile() { 
    return res_outfile;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.LasConverterAlgorithm");
    
    LasConverter tmpModule = new LasConverter(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("pNorth",  (Double) pnorth); 
    logger.info("pNorth " + ( (Double) pnorth) );
    inputs.put("pSouth",  (Double) psouth); 
    logger.info("pSouth " + ( (Double) psouth) );
    inputs.put("doInfo",  (Boolean) doinfo); 
    logger.info("doInfo " + ( (Boolean) doinfo) );
    inputs.put("doHeader",  (Boolean) doheader); 
    logger.info("doHeader " + ( (Boolean) doheader) );
    inputs.put("pIntensityrange",  (String) pintensityrange); 
    logger.info("pIntensityrange " + ( (String) pintensityrange) );
    inputs.put("pImpulses",  (String) pimpulses); 
    logger.info("pImpulses " + ( (String) pimpulses) );
    inputs.put("doBbox",  (Boolean) dobbox); 
    logger.info("doBbox " + ( (Boolean) dobbox) );
    inputs.put("outFile",  (String) outfile); 
    logger.info("outFile " + ( (String) outfile) );
    inputs.put("pWest",  (Double) pwest); 
    logger.info("pWest " + ( (Double) pwest) );
    inputs.put("inPolygons",  (String) inpolygons); 
    logger.info("inPolygons " + ( (String) inpolygons) );
    inputs.put("inFile",  (String) infile); 
    logger.info("inFile " + ( (String) infile) );
    inputs.put("pClasses",  (String) pclasses); 
    logger.info("pClasses " + ( (String) pclasses) );
    inputs.put("pEast",  (Double) peast); 
    logger.info("pEast " + ( (Double) peast) );
    
    // trigger execution of the module 
    try { 
        java.util.logging.Logger uLog = java.util.logging.Logger.getLogger(RasterReprojectorAlgorithm.class.getName()); 
        ComponentAccess.setInputData(inputs, tmpModule, uLog); 
    } catch (Exception ex) { 
       ex.printStackTrace();
    }
    // trigger execution of the module 
    try { 
        java.util.logging.Logger uLog = java.util.logging.Logger.getLogger(RasterReprojectorAlgorithm.class.getName()); 
        ComponentAccess.callAnnotated(tmpModule, Initialize.class, true); 
    } catch (Exception ex) { 
       ex.printStackTrace();
    }
    try { 
        ComponentAccess.callAnnotated(tmpModule, Execute.class, false); 
    } catch (Exception ex) { 
       ex.printStackTrace();
    }
    try { 
        ComponentAccess.callAnnotated(tmpModule, Finalize.class, true); 
    } catch (Exception ex) { 
       ex.printStackTrace();
    }
    
    // get the results 
    HashMap<String, String> outputs = new HashMap<String, String>();
    ComponentAccess cA = new ComponentAccess(tmpModule); 
    Collection<Access> outputsCollection = cA.outputs(); 
    
    outputs.put("outFile", "String"); 
    
    res_outfile = (String) outfile; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outFile")) { 
            // and put them into the output result variables 
            res_outfile = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

