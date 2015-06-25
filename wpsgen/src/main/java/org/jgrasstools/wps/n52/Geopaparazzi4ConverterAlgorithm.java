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
import org.jgrasstools.modules.Geopaparazzi4Converter; 
 
@Algorithm(version = "1.0.0", abstrakt = "Converts a geopaparazzi 4 project database into shapefiles.")
public class Geopaparazzi4ConverterAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(Geopaparazzi4ConverterAlgorithm.class); 

  public Geopaparazzi4ConverterAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String ingeopaparazzi;

  @LiteralDataInput(identifier = "inGeopaparazzi", abstrakt = "The geopaparazzi database file (*.gpap).", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinGeopaparazzi(String ingeopaparazzi) { 
    this.ingeopaparazzi = ingeopaparazzi;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = boolean
    // fieldBindingType = Boolean
    // fieldVariableType = Boolean
  private Boolean donotes;

  @LiteralDataInput(identifier = "doNotes", abstrakt = "Flag to create notes", minOccurs = 1, maxOccurs = 1, binding = LiteralBooleanBinding.class)
  public void setdoNotes(Boolean donotes) { 
    this.donotes = donotes;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = boolean
    // fieldBindingType = Boolean
    // fieldVariableType = Boolean
  private Boolean dologlines;

  @LiteralDataInput(identifier = "doLoglines", abstrakt = "Flag to create log lines", minOccurs = 1, maxOccurs = 1, binding = LiteralBooleanBinding.class)
  public void setdoLoglines(Boolean dologlines) { 
    this.dologlines = dologlines;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = boolean
    // fieldBindingType = Boolean
    // fieldVariableType = Boolean
  private Boolean dologpoints;

  @LiteralDataInput(identifier = "doLogpoints", abstrakt = "Flag to create log points", minOccurs = 1, maxOccurs = 1, binding = LiteralBooleanBinding.class)
  public void setdoLogpoints(Boolean dologpoints) { 
    this.dologpoints = dologpoints;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = boolean
    // fieldBindingType = Boolean
    // fieldVariableType = Boolean
  private Boolean domedia;

  @LiteralDataInput(identifier = "doMedia", abstrakt = "Flag to create media points", minOccurs = 1, maxOccurs = 1, binding = LiteralBooleanBinding.class)
  public void setdoMedia(Boolean domedia) { 
    this.domedia = domedia;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfolder
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outdata;

  @LiteralDataInput(identifier = "outData", abstrakt = "The output folder", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutData(String outdata) { 
    this.outdata = outdata;
  }

  private String res_outdata;

  @LiteralDataOutput(identifier = "res_outData", abstrakt = "The output folder", binding = LiteralStringBinding.class)
  public String getRes_outData() { 
    return res_outdata;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.Geopaparazzi4ConverterAlgorithm");
    
    Geopaparazzi4Converter tmpModule = new Geopaparazzi4Converter(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("inGeopaparazzi",  (String) ingeopaparazzi); 
    logger.info("inGeopaparazzi " + ( (String) ingeopaparazzi) );
    inputs.put("doMedia",  (Boolean) domedia); 
    logger.info("doMedia " + ( (Boolean) domedia) );
    inputs.put("doLogpoints",  (Boolean) dologpoints); 
    logger.info("doLogpoints " + ( (Boolean) dologpoints) );
    inputs.put("doNotes",  (Boolean) donotes); 
    logger.info("doNotes " + ( (Boolean) donotes) );
    inputs.put("doLoglines",  (Boolean) dologlines); 
    logger.info("doLoglines " + ( (Boolean) dologlines) );
    inputs.put("outData",  (String) outdata); 
    logger.info("outData " + ( (String) outdata) );
    
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
    
    outputs.put("outData", "String"); 
    
    res_outdata = (String) outdata; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outData")) { 
            // and put them into the output result variables 
            res_outdata = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

