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
import org.jgrasstools.modules.Mosaic12; 
 
@Algorithm(version = "1.0.0", abstrakt = "Module for patching max 12 rasters.")
public class Mosaic12Algorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(Mosaic12Algorithm.class); 

  public Mosaic12Algorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inmap1;

  @LiteralDataInput(identifier = "inMap1", abstrakt = "The Map N.1 to be patched", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinMap1(String inmap1) { 
    this.inmap1 = inmap1;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inmap2;

  @LiteralDataInput(identifier = "inMap2", abstrakt = "The Map N.2 to be patched", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinMap2(String inmap2) { 
    this.inmap2 = inmap2;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inmap3;

  @LiteralDataInput(identifier = "inMap3", abstrakt = "The optional Map N.3 to be patched", minOccurs = 0, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinMap3(String inmap3) { 
    this.inmap3 = inmap3;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inmap4;

  @LiteralDataInput(identifier = "inMap4", abstrakt = "The optional Map N.4 to be patched", minOccurs = 0, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinMap4(String inmap4) { 
    this.inmap4 = inmap4;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inmap5;

  @LiteralDataInput(identifier = "inMap5", abstrakt = "The optional Map N.5 to be patched", minOccurs = 0, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinMap5(String inmap5) { 
    this.inmap5 = inmap5;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inmap6;

  @LiteralDataInput(identifier = "inMap6", abstrakt = "The optional Map N.6 to be patched", minOccurs = 0, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinMap6(String inmap6) { 
    this.inmap6 = inmap6;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inmap7;

  @LiteralDataInput(identifier = "inMap7", abstrakt = "The optional Map N.7 to be patched", minOccurs = 0, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinMap7(String inmap7) { 
    this.inmap7 = inmap7;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inmap8;

  @LiteralDataInput(identifier = "inMap8", abstrakt = "The optional Map N.8 to be patched", minOccurs = 0, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinMap8(String inmap8) { 
    this.inmap8 = inmap8;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inmap9;

  @LiteralDataInput(identifier = "inMap9", abstrakt = "The optional Map N.9 to be patched", minOccurs = 0, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinMap9(String inmap9) { 
    this.inmap9 = inmap9;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inmap10;

  @LiteralDataInput(identifier = "inMap10", abstrakt = "The optional Map N.10 to be patched", minOccurs = 0, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinMap10(String inmap10) { 
    this.inmap10 = inmap10;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inmap11;

  @LiteralDataInput(identifier = "inMap11", abstrakt = "The optional Map N.11 to be patched", minOccurs = 0, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinMap11(String inmap11) { 
    this.inmap11 = inmap11;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inmap12;

  @LiteralDataInput(identifier = "inMap12", abstrakt = "The optional Map N.12 to be patched", minOccurs = 0, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinMap12(String inmap12) { 
    this.inmap12 = inmap12;
  }

    // inputOutputIndicator = input
    // fileIndicator = combo:nearest neightbour,bilinear,bicubic
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String pinterpolation;

  @LiteralDataInput(identifier = "pInterpolation", abstrakt = "The interpolation type to use", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setpInterpolation(String pinterpolation) { 
    this.pinterpolation = pinterpolation;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outmap;

  @LiteralDataInput(identifier = "outMap", abstrakt = "The patched map.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutMap(String outmap) { 
    this.outmap = outmap;
  }

  private String res_outmap;

  @LiteralDataOutput(identifier = "res_outMap", abstrakt = "The patched map.", binding = LiteralStringBinding.class)
  public String getRes_outMap() { 
    return res_outmap;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.Mosaic12Algorithm");
    
    Mosaic12 tmpModule = new Mosaic12(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("pInterpolation",  (String) pinterpolation); 
    logger.info("pInterpolation " + ( (String) pinterpolation) );
    inputs.put("inMap1",  (String) inmap1); 
    logger.info("inMap1 " + ( (String) inmap1) );
    inputs.put("inMap2",  (String) inmap2); 
    logger.info("inMap2 " + ( (String) inmap2) );
    inputs.put("inMap5",  (String) inmap5); 
    logger.info("inMap5 " + ( (String) inmap5) );
    inputs.put("inMap6",  (String) inmap6); 
    logger.info("inMap6 " + ( (String) inmap6) );
    inputs.put("inMap3",  (String) inmap3); 
    logger.info("inMap3 " + ( (String) inmap3) );
    inputs.put("inMap4",  (String) inmap4); 
    logger.info("inMap4 " + ( (String) inmap4) );
    inputs.put("inMap8",  (String) inmap8); 
    logger.info("inMap8 " + ( (String) inmap8) );
    inputs.put("inMap7",  (String) inmap7); 
    logger.info("inMap7 " + ( (String) inmap7) );
    inputs.put("inMap9",  (String) inmap9); 
    logger.info("inMap9 " + ( (String) inmap9) );
    inputs.put("inMap11",  (String) inmap11); 
    logger.info("inMap11 " + ( (String) inmap11) );
    inputs.put("inMap10",  (String) inmap10); 
    logger.info("inMap10 " + ( (String) inmap10) );
    inputs.put("inMap12",  (String) inmap12); 
    logger.info("inMap12 " + ( (String) inmap12) );
    inputs.put("outMap",  (String) outmap); 
    logger.info("outMap " + ( (String) outmap) );
    
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
    
    outputs.put("outMap", "String"); 
    
    res_outmap = (String) outmap; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outMap")) { 
            // and put them into the output result variables 
            res_outmap = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

