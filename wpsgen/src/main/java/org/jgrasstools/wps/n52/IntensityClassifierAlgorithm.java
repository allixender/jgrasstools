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
import org.jgrasstools.modules.IntensityClassifier; 
 
@Algorithm(version = "1.0.0", abstrakt = "Module for the calculation of the flooding intensity.")
public class IntensityClassifierAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(IntensityClassifierAlgorithm.class); 

  public IntensityClassifierAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
    // uom = m
  private String inwaterdepth;

  @LiteralDataInput(identifier = "inWaterDepth", abstrakt = "The map of the water depth.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinWaterDepth(String inwaterdepth) { 
    this.inwaterdepth = inwaterdepth;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
    // uom = m/s
  private String invelocity;

  @LiteralDataInput(identifier = "inVelocity", abstrakt = "The map of the water velocity.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinVelocity(String invelocity) { 
    this.invelocity = invelocity;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = Double
    // fieldBindingType = Double
    // fieldVariableType = Double
    // uom = m
  private Double pupperthreswaterdepth;

  @LiteralDataInput(identifier = "pUpperThresWaterdepth", abstrakt = "The upper threshold value for the water depth.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpUpperThresWaterdepth(Double pupperthreswaterdepth) { 
    this.pupperthreswaterdepth = pupperthreswaterdepth;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = Double
    // fieldBindingType = Double
    // fieldVariableType = Double
    // uom = m2/s
  private Double pupperthresvelocitywaterdepth;

  @LiteralDataInput(identifier = "pUpperThresVelocityWaterdepth", abstrakt = "The upper threshold value for the product of water depth and velocity.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpUpperThresVelocityWaterdepth(Double pupperthresvelocitywaterdepth) { 
    this.pupperthresvelocitywaterdepth = pupperthresvelocitywaterdepth;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = Double
    // fieldBindingType = Double
    // fieldVariableType = Double
    // uom = m
  private Double plowerthreswaterdepth;

  @LiteralDataInput(identifier = "pLowerThresWaterdepth", abstrakt = "The lower threshold value for the water depth.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpLowerThresWaterdepth(Double plowerthreswaterdepth) { 
    this.plowerthreswaterdepth = plowerthreswaterdepth;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = Double
    // fieldBindingType = Double
    // fieldVariableType = Double
    // uom = m2/s
  private Double plowerthresvelocitywaterdepth;

  @LiteralDataInput(identifier = "pLowerThresVelocityWaterdepth", abstrakt = "The lower threshold value for the product of water depth and velocity.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpLowerThresVelocityWaterdepth(Double plowerthresvelocitywaterdepth) { 
    this.plowerthresvelocitywaterdepth = plowerthresvelocitywaterdepth;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outintensity;

  @LiteralDataInput(identifier = "outIntensity", abstrakt = "The map of flooding intensity.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutIntensity(String outintensity) { 
    this.outintensity = outintensity;
  }

  private String res_outintensity;

  @LiteralDataOutput(identifier = "res_outIntensity", abstrakt = "The map of flooding intensity.", binding = LiteralStringBinding.class)
  public String getRes_outIntensity() { 
    return res_outintensity;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.IntensityClassifierAlgorithm");
    
    IntensityClassifier tmpModule = new IntensityClassifier(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("pLowerThresWaterdepth",  (Double) plowerthreswaterdepth); 
    logger.info("pLowerThresWaterdepth " + ( (Double) plowerthreswaterdepth) );
    inputs.put("pUpperThresVelocityWaterdepth",  (Double) pupperthresvelocitywaterdepth); 
    logger.info("pUpperThresVelocityWaterdepth " + ( (Double) pupperthresvelocitywaterdepth) );
    inputs.put("inVelocity",  (String) invelocity); 
    logger.info("inVelocity " + ( (String) invelocity) );
    inputs.put("inWaterDepth",  (String) inwaterdepth); 
    logger.info("inWaterDepth " + ( (String) inwaterdepth) );
    inputs.put("pLowerThresVelocityWaterdepth",  (Double) plowerthresvelocitywaterdepth); 
    logger.info("pLowerThresVelocityWaterdepth " + ( (Double) plowerthresvelocitywaterdepth) );
    inputs.put("outIntensity",  (String) outintensity); 
    logger.info("outIntensity " + ( (String) outintensity) );
    inputs.put("pUpperThresWaterdepth",  (Double) pupperthreswaterdepth); 
    logger.info("pUpperThresWaterdepth " + ( (Double) pupperthreswaterdepth) );
    
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
    
    outputs.put("outIntensity", "String"); 
    
    res_outintensity = (String) outintensity; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outIntensity")) { 
            // and put them into the output result variables 
            res_outintensity = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

