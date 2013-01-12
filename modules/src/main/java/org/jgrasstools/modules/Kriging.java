/* This file is part of JGrasstools (http://www.jgrasstools.org)
 * (C) HydroloGIS - www.hydrologis.com 
 * 
 * JGrasstools is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.jgrasstools.modules;

import static org.jgrasstools.hortonmachine.i18n.HortonMessages.OMSKRIGING_AUTHORCONTACTS;
import static org.jgrasstools.hortonmachine.i18n.HortonMessages.OMSKRIGING_AUTHORNAMES;
import static org.jgrasstools.hortonmachine.i18n.HortonMessages.OMSKRIGING_DESCRIPTION;
import static org.jgrasstools.hortonmachine.i18n.HortonMessages.OMSKRIGING_KEYWORDS;
import static org.jgrasstools.hortonmachine.i18n.HortonMessages.OMSKRIGING_LABEL;
import static org.jgrasstools.hortonmachine.i18n.HortonMessages.OMSKRIGING_LICENSE;
import static org.jgrasstools.hortonmachine.i18n.HortonMessages.OMSKRIGING_NAME;
import static org.jgrasstools.hortonmachine.i18n.HortonMessages.OMSKRIGING_STATUS;
import static org.jgrasstools.hortonmachine.i18n.HortonMessages.OMSKRIGING_doIncludezero_DESCRIPTION;
import static org.jgrasstools.hortonmachine.i18n.HortonMessages.OMSKRIGING_doLogarithmic_DESCRIPTION;
import static org.jgrasstools.hortonmachine.i18n.HortonMessages.OMSKRIGING_fInterpolateid_DESCRIPTION;
import static org.jgrasstools.hortonmachine.i18n.HortonMessages.OMSKRIGING_fPointZ_DESCRIPTION;
import static org.jgrasstools.hortonmachine.i18n.HortonMessages.OMSKRIGING_fStationsZ_DESCRIPTION;
import static org.jgrasstools.hortonmachine.i18n.HortonMessages.OMSKRIGING_fStationsid_DESCRIPTION;
import static org.jgrasstools.hortonmachine.i18n.HortonMessages.OMSKRIGING_inData_DESCRIPTION;
import static org.jgrasstools.hortonmachine.i18n.HortonMessages.OMSKRIGING_inInterpolate_DESCRIPTION;
import static org.jgrasstools.hortonmachine.i18n.HortonMessages.OMSKRIGING_inInterpolationGrid_DESCRIPTION;
import static org.jgrasstools.hortonmachine.i18n.HortonMessages.OMSKRIGING_inStations_DESCRIPTION;
import static org.jgrasstools.hortonmachine.i18n.HortonMessages.OMSKRIGING_outData_DESCRIPTION;
import static org.jgrasstools.hortonmachine.i18n.HortonMessages.OMSKRIGING_outGrid_DESCRIPTION;
import static org.jgrasstools.hortonmachine.i18n.HortonMessages.OMSKRIGING_pA_DESCRIPTION;
import static org.jgrasstools.hortonmachine.i18n.HortonMessages.OMSKRIGING_pIntegralscale_DESCRIPTION;
import static org.jgrasstools.hortonmachine.i18n.HortonMessages.OMSKRIGING_pMode_DESCRIPTION;
import static org.jgrasstools.hortonmachine.i18n.HortonMessages.OMSKRIGING_pNug_DESCRIPTION;
import static org.jgrasstools.hortonmachine.i18n.HortonMessages.OMSKRIGING_pS_DESCRIPTION;
import static org.jgrasstools.hortonmachine.i18n.HortonMessages.OMSKRIGING_pSemivariogramType_DESCRIPTION;
import static org.jgrasstools.hortonmachine.i18n.HortonMessages.OMSKRIGING_pVariance_DESCRIPTION;

import java.util.HashMap;

import oms3.annotations.Author;
import oms3.annotations.Description;
import oms3.annotations.Execute;
import oms3.annotations.In;
import oms3.annotations.Keywords;
import oms3.annotations.Label;
import oms3.annotations.License;
import oms3.annotations.Name;
import oms3.annotations.Out;
import oms3.annotations.Status;
import oms3.annotations.UI;

import org.geotools.coverage.grid.GridCoverage2D;
import org.geotools.coverage.grid.GridGeometry2D;
import org.geotools.feature.FeatureCollection;
import org.jgrasstools.gears.libs.modules.JGTConstants;
import org.jgrasstools.gears.libs.modules.JGTModel;
import org.jgrasstools.hortonmachine.modules.statistics.kriging.OmsKriging;

@Description(OMSKRIGING_DESCRIPTION)
@Author(name = OMSKRIGING_AUTHORNAMES, contact = OMSKRIGING_AUTHORCONTACTS)
@Keywords(OMSKRIGING_KEYWORDS)
@Label(OMSKRIGING_LABEL)
@Name("_" + OMSKRIGING_NAME)
@Status(OMSKRIGING_STATUS)
@License(OMSKRIGING_LICENSE)
public class Kriging extends JGTModel {

    @Description(OMSKRIGING_inStations_DESCRIPTION)
    @UI(JGTConstants.FILEIN_UI_HINT)
    @In
    public String inStations = null;

    @Description(OMSKRIGING_fStationsid_DESCRIPTION)
    @In
    public String fStationsid = null;

    @Description(OMSKRIGING_fStationsZ_DESCRIPTION)
    @In
    public String fStationsZ = null;

    @Description(OMSKRIGING_inData_DESCRIPTION)
    @In
    public HashMap<Integer, double[]> inData = null;

    @Description(OMSKRIGING_inInterpolate_DESCRIPTION)
    @UI(JGTConstants.FILEOUT_UI_HINT)
    @In
    public String inInterpolate = null;

    @Description(OMSKRIGING_fInterpolateid_DESCRIPTION)
    @In
    public String fInterpolateid = null;

    @Description(OMSKRIGING_fPointZ_DESCRIPTION)
    @In
    public String fPointZ = null;

    /**
     * Define the mode. It is possible 4 alternatives: <li>mode ==0, the value
     * to calculate are in a non-regular grid (the coordinates are stored in a
     * {@link FeatureCollection}, pointsToInterpolate. This is a 2-D
     * interpolation, so the z coordinates are null. <li>mode ==1, the value to
     * calculate are in a non-regular grid (the coordinates are stored in a
     * {@link FeatureCollection}, pointsToInterpolate. This is a 3-D
     * interpolation.. <li>mode ==2, the value to calculate are in a regular
     * grid (the coordinates are stored in a {@link GridCoverage2D},
     * gridToInterpolate. This is a 2-D interpolation. <li>mode ==3, the value
     * to calculate are in a regular grid (the coordinates are stored in a
     * {@link GridCoverage2D}, gridToInterpolate. This is a 3-D interpolation,
     * so the grid have to contains a dem.
     */
    @Description(OMSKRIGING_pMode_DESCRIPTION)
    @In
    public int pMode = 0;

    /**
     * The integral scale, this is necessary to calculate the variogram if the
     * program use {@link Kriging2.variogram(rx,ry,rz)}.
     */
    @Description(OMSKRIGING_pIntegralscale_DESCRIPTION)
    @In
    public double[] pIntegralscale = null;

    /**
     * Variance of the measure field.
     */
    @Description(OMSKRIGING_pVariance_DESCRIPTION)
    @In
    public double pVariance = 0;

    /**
     * The logarithm selector, if it's true then the models runs with the log of
     * the data.
     */
    @Description(OMSKRIGING_doLogarithmic_DESCRIPTION)
    @In
    public boolean doLogarithmic = false;

    @Description(OMSKRIGING_inInterpolationGrid_DESCRIPTION)
    @In
    public GridGeometry2D inInterpolationGrid = null;

    public int defaultVariogramMode = 0;

    @Description(OMSKRIGING_pSemivariogramType_DESCRIPTION)
    @In
    public double pSemivariogramType = 0;

    @Description(OMSKRIGING_doIncludezero_DESCRIPTION)
    @In
    public boolean doIncludezero = true;

    @Description(OMSKRIGING_pA_DESCRIPTION)
    @In
    public double pA;

    @Description(OMSKRIGING_pS_DESCRIPTION)
    @In
    public double pS;

    @Description(OMSKRIGING_pNug_DESCRIPTION)
    @In
    public double pNug;

    @Description(OMSKRIGING_outGrid_DESCRIPTION)
    @Out
    public String outGrid = null;

    @Description(OMSKRIGING_outData_DESCRIPTION)
    @Out
    public HashMap<Integer, double[]> outData = null;

    @Execute
    public void process() throws Exception {
        OmsKriging kriging = new OmsKriging();
        kriging.inStations = getVector(inStations);
        kriging.fStationsid = fStationsid;
        kriging.fStationsZ = fStationsZ;
        kriging.inData = inData;
        kriging.inInterpolate = getVector(inInterpolate);
        kriging.fInterpolateid = fInterpolateid;
        kriging.fPointZ = fPointZ;
        kriging.pMode = pMode;
        kriging.pIntegralscale = pIntegralscale;
        kriging.pVariance = pVariance;
        kriging.doLogarithmic = doLogarithmic;
        kriging.inInterpolationGrid = inInterpolationGrid;
        kriging.defaultVariogramMode = defaultVariogramMode;
        kriging.pSemivariogramType = pSemivariogramType;
        kriging.doIncludezero = doIncludezero;
        kriging.pA = pA;
        kriging.pS = pS;
        kriging.pNug = pNug;
        kriging.pm = pm;
        kriging.doProcess = doProcess;
        kriging.doReset = doReset;
        kriging.process();
        dumpRaster(kriging.outGrid, outGrid);
        outData = kriging.outData;
    }
}