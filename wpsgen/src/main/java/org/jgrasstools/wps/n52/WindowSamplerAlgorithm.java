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
import org.jgrasstools.modules.WindowSampler; 
 
@Algorithm(version = "1.0.0", abstrakt = "Module to do coverage downsampling on defined windows.")
public class WindowSamplerAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(WindowSamplerAlgorithm.class); 

  public WindowSamplerAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String ingeodata;

  @LiteralDataInput(identifier = "inGeodata", abstrakt = "The input coverage.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinGeodata(String ingeodata) { 
    this.ingeodata = ingeodata;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = int
    // fieldBindingType = Int
    // fieldVariableType = int
  private int pmode;

  @LiteralDataInput(identifier = "pMode", abstrakt = "The mode to use: average (0 = default), sum (1), max (2), min (3).", minOccurs = 1, maxOccurs = 1, binding = LiteralIntBinding.class)
  public void setpMode(int pmode) { 
    this.pmode = pmode;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = int
    // fieldBindingType = Int
    // fieldVariableType = int
  private int prows;

  @LiteralDataInput(identifier = "pRows", abstrakt = "The windows rows to use (default is 3).", minOccurs = 1, maxOccurs = 1, binding = LiteralIntBinding.class)
  public void setpRows(int prows) { 
    this.prows = prows;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = int
    // fieldBindingType = Int
    // fieldVariableType = int
  private int pcols;

  @LiteralDataInput(identifier = "pCols", abstrakt = "The window cols to use (default is 3).", minOccurs = 1, maxOccurs = 1, binding = LiteralIntBinding.class)
  public void setpCols(int pcols) { 
    this.pcols = pcols;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = Integer
    // fieldBindingType = Int
    // fieldVariableType = Integer
  private Integer pxstep;

  @LiteralDataInput(identifier = "pXstep", abstrakt = "The cols to move the window forward (default is = pCols).", minOccurs = 1, maxOccurs = 1, binding = LiteralIntBinding.class)
  public void setpXstep(Integer pxstep) { 
    this.pxstep = pxstep;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = Integer
    // fieldBindingType = Int
    // fieldVariableType = Integer
  private Integer pystep;

  @LiteralDataInput(identifier = "pYstep", abstrakt = "The rows to move the window forward (default is = pRows).", minOccurs = 1, maxOccurs = 1, binding = LiteralIntBinding.class)
  public void setpYstep(Integer pystep) { 
    this.pystep = pystep;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outgeodata;

  @LiteralDataInput(identifier = "outGeodata", abstrakt = "The output coverage.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutGeodata(String outgeodata) { 
    this.outgeodata = outgeodata;
  }

  private String res_outgeodata;

  @LiteralDataOutput(identifier = "res_outGeodata", abstrakt = "The output coverage.", binding = LiteralStringBinding.class)
  public String getRes_outGeodata() { 
    return res_outgeodata;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.WindowSamplerAlgorithm");
    
    WindowSampler tmpModule = new WindowSampler(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("pMode",  (int) pmode); 
    logger.info("pMode " + ( (int) pmode) );
    inputs.put("pXstep",  (Integer) pxstep); 
    logger.info("pXstep " + ( (Integer) pxstep) );
    inputs.put("pRows",  (int) prows); 
    logger.info("pRows " + ( (int) prows) );
    inputs.put("outGeodata",  (String) outgeodata); 
    logger.info("outGeodata " + ( (String) outgeodata) );
    inputs.put("pYstep",  (Integer) pystep); 
    logger.info("pYstep " + ( (Integer) pystep) );
    inputs.put("pCols",  (int) pcols); 
    logger.info("pCols " + ( (int) pcols) );
    inputs.put("inGeodata",  (String) ingeodata); 
    logger.info("inGeodata " + ( (String) ingeodata) );
    
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
    
    outputs.put("outGeodata", "String"); 
    
    res_outgeodata = (String) outgeodata; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outGeodata")) { 
            // and put them into the output result variables 
            res_outgeodata = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

