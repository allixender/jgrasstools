/*
 * This file is part of JGrasstools (http://www.jgrasstools.org)
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
package org.jgrasstools.gears.io.las.core.liblas;

import java.io.File;
import java.io.IOException;

import org.jgrasstools.gears.io.las.core.ALasReader;
import org.jgrasstools.gears.io.las.core.LasRecord;
import org.jgrasstools.gears.utils.CrsUtilities;
import org.opengis.referencing.crs.CoordinateReferenceSystem;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

/**
 * A laslib based native las reader.
 * 
 * @author Andrea Antonello (www.hydrologis.com)
 */
public class LiblasReader extends ALasReader {
    private static LiblasWrapper WRAPPER;

    /**
     * Loads the native libs creating the native wrapper.
     * 
     * @param nativeLibPath the path to add or <code>null</code>.
     * @param libName the lib name or <code>null</code>, in which case "lib_c" is used.
     * @return <code>true</code>, if the lib could be loaded.
     */
    public static boolean loadNativeLibrary( String nativeLibPath, String libName ) {
        try {
            String name = "las_c";
            if (libName == null)
                libName = name;
            if (nativeLibPath != null)
                NativeLibrary.addSearchPath(libName, nativeLibPath);
            WRAPPER = (LiblasWrapper) Native.loadLibrary(libName, LiblasWrapper.class);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private File lasFile;
    private long fileHandle;
    private long currentPointRef;
    private LiblasHeader headerHandle = null;
    private CoordinateReferenceSystem crs;
    private byte pointDataFormat;

    public LiblasReader( File lasFile, CoordinateReferenceSystem crs ) {
        this.lasFile = lasFile;
        if (crs != null) {
            this.crs = crs;
        } else {
            try {
                this.crs = CrsUtilities.readProjectionFile(lasFile.getAbsolutePath(), "las");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (WRAPPER == null) {
            loadNativeLibrary(null, null);
        }
    }

    public void open() {
        fileHandle = WRAPPER.LASReader_Create(lasFile.getAbsolutePath());
        LiblasHeader header = getHeader();
        pointDataFormat = header.getPointDataFormat();
    }

    public LiblasHeader getHeader() {
        if (headerHandle == null) {
            headerHandle = new LiblasHeader(WRAPPER, WRAPPER.LASReader_GetHeader(fileHandle), crs);
        }
        return headerHandle;
    }

    public boolean hasNextPoint() {
        currentPointRef = WRAPPER.LASReader_GetNextPoint(fileHandle);
        return currentPointRef != 0;
    }

    public LasRecord getNextPoint() {
        return getPointAtRef(currentPointRef);
    }

    private LasRecord getPointAtRef( long ref ) {
        double x = WRAPPER.LASPoint_GetX(ref);
        double y = WRAPPER.LASPoint_GetY(ref);
        double z = WRAPPER.LASPoint_GetZ(ref);

        LasRecord dot = new LasRecord();
        dot.x = x;
        dot.y = y;
        dot.z = z;

        short intensity = WRAPPER.LASPoint_GetIntensity(ref);
        int returnNumber = WRAPPER.LASPoint_GetReturnNumber(ref);
        int numberOfReturns = WRAPPER.LASPoint_GetNumberOfReturns(ref);
        byte classification = WRAPPER.LASPoint_GetClassification(ref);

        dot.intensity = intensity;
        dot.classification = classification;
        dot.returnNumber = returnNumber;
        dot.numberOfReturns = numberOfReturns;
        if (pointDataFormat == 1) {
            dot.gpsTime = WRAPPER.LASPoint_GetTime(ref);
        } else if (pointDataFormat == 2) {
            long colorHandle = WRAPPER.LASPoint_GetColor(ref);
            dot.color[0] = WRAPPER.LASPoint_GetRed(colorHandle);
            dot.color[1] = WRAPPER.LASPoint_GetGreen(colorHandle);
            dot.color[2] = WRAPPER.LASPoint_GetBlue(colorHandle);
        } else if (pointDataFormat == 3) {
            dot.gpsTime = WRAPPER.LASPoint_GetTime(ref);
            long colorHandle = WRAPPER.LASPoint_GetColor(ref);
            dot.color[0] = WRAPPER.LASPoint_GetRed(colorHandle);
            dot.color[1] = WRAPPER.LASPoint_GetGreen(colorHandle);
            dot.color[2] = WRAPPER.LASPoint_GetBlue(colorHandle);
        }
        return dot;
    }

    public LasRecord getPointAt( long position ) {
        currentPointRef = WRAPPER.LASReader_GetPointAt(fileHandle, position);
        return getPointAtRef(currentPointRef);
    }

    public void close() {
        WRAPPER.LASReader_Destroy(fileHandle);
    }

    @Override
    public File getLasFile() {
        return lasFile;
    }

    @Override
    public double[] readNextLasXYZAddress() throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void seek( long pointNumber ) throws IOException {
        WRAPPER.LASReader_Seek(fileHandle, pointNumber);
    }

    @Override
    public void setOverrideGpsTimeType( int type ) {

    }

}
