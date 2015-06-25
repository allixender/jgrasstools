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
import org.jgrasstools.modules.EnergyIndexCalculator; 
 
@Algorithm(version = "1.0.0", abstrakt = "The Adige model.")
public class EnergyIndexCalculatorAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(EnergyIndexCalculatorAlgorithm.class); 

  public EnergyIndexCalculatorAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inelev;

  @LiteralDataInput(identifier = "inElev", abstrakt = "The digital elevation model (DEM).", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinElev(String inelev) { 
    this.inelev = inelev;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inbasins;

  @LiteralDataInput(identifier = "inBasins", abstrakt = "The map of subbasins with the id as category.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinBasins(String inbasins) { 
    this.inbasins = inbasins;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String incurvatures;

  @LiteralDataInput(identifier = "inCurvatures", abstrakt = "The map of curvatures [nabla classes].", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinCurvatures(String incurvatures) { 
    this.incurvatures = incurvatures;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inaspect;

  @LiteralDataInput(identifier = "inAspect", abstrakt = "The map of aspect in radiants.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinAspect(String inaspect) { 
    this.inaspect = inaspect;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inslope;

  @LiteralDataInput(identifier = "inSlope", abstrakt = "The map of slope in radiants.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinSlope(String inslope) { 
    this.inslope = inslope;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = int
    // fieldBindingType = Int
    // fieldVariableType = int
  private int pes;

  @LiteralDataInput(identifier = "pEs", abstrakt = "Number of altimetric bands.", minOccurs = 1, maxOccurs = 1, binding = LiteralIntBinding.class)
  public void setpEs(int pes) { 
    this.pes = pes;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = int
    // fieldBindingType = Int
    // fieldVariableType = int
  private int pei;

  @LiteralDataInput(identifier = "pEi", abstrakt = "Number of energetic bands.", minOccurs = 1, maxOccurs = 1, binding = LiteralIntBinding.class)
  public void setpEi(int pei) { 
    this.pei = pei;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double pdt;

  @LiteralDataInput(identifier = "pDt", abstrakt = "Aggregation interval of the data [h].", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpDt(double pdt) { 
    this.pdt = pdt;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outaltimetry;

  @LiteralDataInput(identifier = "outAltimetry", abstrakt = "Output list of altimetric bands information.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutAltimetry(String outaltimetry) { 
    this.outaltimetry = outaltimetry;
  }

  private String res_outaltimetry;

  @LiteralDataOutput(identifier = "res_outAltimetry", abstrakt = "Output list of altimetric bands information.", binding = LiteralStringBinding.class)
  public String getRes_outAltimetry() { 
    return res_outaltimetry;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outenergy;

  @LiteralDataInput(identifier = "outEnergy", abstrakt = "Output list of energetic bands information.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutEnergy(String outenergy) { 
    this.outenergy = outenergy;
  }

  private String res_outenergy;

  @LiteralDataOutput(identifier = "res_outEnergy", abstrakt = "Output list of energetic bands information.", binding = LiteralStringBinding.class)
  public String getRes_outEnergy() { 
    return res_outenergy;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outarea;

  @LiteralDataInput(identifier = "outArea", abstrakt = "Output list of areas of the energetic and altimetric bands.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutArea(String outarea) { 
    this.outarea = outarea;
  }

  private String res_outarea;

  @LiteralDataOutput(identifier = "res_outArea", abstrakt = "Output list of areas of the energetic and altimetric bands.", binding = LiteralStringBinding.class)
  public String getRes_outArea() { 
    return res_outarea;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.EnergyIndexCalculatorAlgorithm");
    
    EnergyIndexCalculator tmpModule = new EnergyIndexCalculator(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("outArea",  (String) outarea); 
    logger.info("outArea " + ( (String) outarea) );
    inputs.put("pDt",  (double) pdt); 
    logger.info("pDt " + ( (double) pdt) );
    inputs.put("inSlope",  (String) inslope); 
    logger.info("inSlope " + ( (String) inslope) );
    inputs.put("inAspect",  (String) inaspect); 
    logger.info("inAspect " + ( (String) inaspect) );
    inputs.put("inBasins",  (String) inbasins); 
    logger.info("inBasins " + ( (String) inbasins) );
    inputs.put("pEi",  (int) pei); 
    logger.info("pEi " + ( (int) pei) );
    inputs.put("inElev",  (String) inelev); 
    logger.info("inElev " + ( (String) inelev) );
    inputs.put("outEnergy",  (String) outenergy); 
    logger.info("outEnergy " + ( (String) outenergy) );
    inputs.put("pEs",  (int) pes); 
    logger.info("pEs " + ( (int) pes) );
    inputs.put("inCurvatures",  (String) incurvatures); 
    logger.info("inCurvatures " + ( (String) incurvatures) );
    inputs.put("outAltimetry",  (String) outaltimetry); 
    logger.info("outAltimetry " + ( (String) outaltimetry) );
    
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
    
    outputs.put("outArea", "String"); 
    outputs.put("outEnergy", "String"); 
    outputs.put("outAltimetry", "String"); 
    
    res_outarea = (String) outarea; 
    res_outenergy = (String) outenergy; 
    res_outaltimetry = (String) outaltimetry; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outArea")) { 
            // and put them into the output result variables 
            res_outarea = (String) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outEnergy")) { 
            // and put them into the output result variables 
            res_outenergy = (String) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outAltimetry")) { 
            // and put them into the output result variables 
            res_outaltimetry = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

