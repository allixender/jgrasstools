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
import org.jgrasstools.modules.Shalstab; 
 
@Algorithm(version = "1.0.0", abstrakt = "A version of the OmsShalstab stability model.")
public class ShalstabAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(ShalstabAlgorithm.class); 

  public ShalstabAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inslope;

  @LiteralDataInput(identifier = "inSlope", abstrakt = "The map of slope.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinSlope(String inslope) { 
    this.inslope = inslope;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String intca;

  @LiteralDataInput(identifier = "inTca", abstrakt = "The map of contributing area.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinTca(String intca) { 
    this.intca = intca;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
    // uom = m^2/day
  private String intrasmissivity;

  @LiteralDataInput(identifier = "inTrasmissivity", abstrakt = "The map of trasmissivity.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinTrasmissivity(String intrasmissivity) { 
    this.intrasmissivity = intrasmissivity;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
    // uom = m^2/day
  private double ptrasmissivity;

  @LiteralDataInput(identifier = "pTrasmissivity", abstrakt = "A constant of trasmissivity to use instead of the map.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpTrasmissivity(double ptrasmissivity) { 
    this.ptrasmissivity = ptrasmissivity;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String intgphi;

  @LiteralDataInput(identifier = "inTgphi", abstrakt = "The map of the tangent of the friction tangent angle.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinTgphi(String intgphi) { 
    this.intgphi = intgphi;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double ptgphi;

  @LiteralDataInput(identifier = "pTgphi", abstrakt = "A constant of tangent of the friction angle to use instead of the map.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpTgphi(double ptgphi) { 
    this.ptgphi = ptgphi;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
    // uom = Pa
  private String incohesion;

  @LiteralDataInput(identifier = "inCohesion", abstrakt = "The map of cohesion.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinCohesion(String incohesion) { 
    this.incohesion = incohesion;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
    // uom = Pa
  private double pcohesion;

  @LiteralDataInput(identifier = "pCohesion", abstrakt = "A constant of cohesion to use instead of the map.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpCohesion(double pcohesion) { 
    this.pcohesion = pcohesion;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
    // uom = m
  private String insdepth;

  @LiteralDataInput(identifier = "inSdepth", abstrakt = "The map of soil depth.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinSdepth(String insdepth) { 
    this.insdepth = insdepth;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
    // uom = m
  private double psdepth;

  @LiteralDataInput(identifier = "pSdepth", abstrakt = "A constant of soil depth to use instead of the map.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpSdepth(double psdepth) { 
    this.psdepth = psdepth;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
    // uom = mm/day
  private String inq;

  @LiteralDataInput(identifier = "inQ", abstrakt = "The map of effective precipitation.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinQ(String inq) { 
    this.inq = inq;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
    // uom = mm/day
  private double pq;

  @LiteralDataInput(identifier = "pQ", abstrakt = "A constant of effective precipitation to use instead of the map.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpQ(double pq) { 
    this.pq = pq;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inrho;

  @LiteralDataInput(identifier = "inRho", abstrakt = "The map of rho.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinRho(String inrho) { 
    this.inrho = inrho;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double prho;

  @LiteralDataInput(identifier = "pRho", abstrakt = "A constant of rho to use instead of the map.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpRho(double prho) { 
    this.prho = prho;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double prock;

  @LiteralDataInput(identifier = "pRock", abstrakt = "A value for the slope for rock.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpRock(double prock) { 
    this.prock = prock;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outqcrit;

  @LiteralDataInput(identifier = "outQcrit", abstrakt = "The map of qcrit.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutQcrit(String outqcrit) { 
    this.outqcrit = outqcrit;
  }

  private String res_outqcrit;

  @LiteralDataOutput(identifier = "res_outQcrit", abstrakt = "The map of qcrit.", binding = LiteralStringBinding.class)
  public String getRes_outQcrit() { 
    return res_outqcrit;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outshalstab;

  @LiteralDataInput(identifier = "outShalstab", abstrakt = "The map of classi.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutShalstab(String outshalstab) { 
    this.outshalstab = outshalstab;
  }

  private String res_outshalstab;

  @LiteralDataOutput(identifier = "res_outShalstab", abstrakt = "The map of classi.", binding = LiteralStringBinding.class)
  public String getRes_outShalstab() { 
    return res_outshalstab;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.ShalstabAlgorithm");
    
    Shalstab tmpModule = new Shalstab(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("inTrasmissivity",  (String) intrasmissivity); 
    logger.info("inTrasmissivity " + ( (String) intrasmissivity) );
    inputs.put("inTca",  (String) intca); 
    logger.info("inTca " + ( (String) intca) );
    inputs.put("inSlope",  (String) inslope); 
    logger.info("inSlope " + ( (String) inslope) );
    inputs.put("pSdepth",  (double) psdepth); 
    logger.info("pSdepth " + ( (double) psdepth) );
    inputs.put("pQ",  (double) pq); 
    logger.info("pQ " + ( (double) pq) );
    inputs.put("inQ",  (String) inq); 
    logger.info("inQ " + ( (String) inq) );
    inputs.put("pRho",  (double) prho); 
    logger.info("pRho " + ( (double) prho) );
    inputs.put("inCohesion",  (String) incohesion); 
    logger.info("inCohesion " + ( (String) incohesion) );
    inputs.put("outShalstab",  (String) outshalstab); 
    logger.info("outShalstab " + ( (String) outshalstab) );
    inputs.put("pTgphi",  (double) ptgphi); 
    logger.info("pTgphi " + ( (double) ptgphi) );
    inputs.put("inSdepth",  (String) insdepth); 
    logger.info("inSdepth " + ( (String) insdepth) );
    inputs.put("pTrasmissivity",  (double) ptrasmissivity); 
    logger.info("pTrasmissivity " + ( (double) ptrasmissivity) );
    inputs.put("pRock",  (double) prock); 
    logger.info("pRock " + ( (double) prock) );
    inputs.put("inTgphi",  (String) intgphi); 
    logger.info("inTgphi " + ( (String) intgphi) );
    inputs.put("inRho",  (String) inrho); 
    logger.info("inRho " + ( (String) inrho) );
    inputs.put("pCohesion",  (double) pcohesion); 
    logger.info("pCohesion " + ( (double) pcohesion) );
    inputs.put("outQcrit",  (String) outqcrit); 
    logger.info("outQcrit " + ( (String) outqcrit) );
    
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
    
    outputs.put("outShalstab", "String"); 
    outputs.put("outQcrit", "String"); 
    
    res_outshalstab = (String) outshalstab; 
    res_outqcrit = (String) outqcrit; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outShalstab")) { 
            // and put them into the output result variables 
            res_outshalstab = (String) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outQcrit")) { 
            // and put them into the output result variables 
            res_outqcrit = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

