/*
 * Matrix Service for the GLIMMPSE Software System.  Processes
 * incoming HTTP requests for matrix operations like addition, substraction
 * kronecker multiplication and so on
 * 
 * Copyright (C) 2010 Regents of the University of Colorado.
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA  02110-1301, USA.
 */
package edu.ucdenver.bios.matrixsvc.resource;

import org.apache.commons.math3.linear.RealMatrix;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import edu.cudenver.bios.matrix.MatrixUtils;
import edu.ucdenver.bios.matrixsvc.application.MatrixConstants;
import edu.ucdenver.bios.webservice.common.domain.NamedMatrix;

/**
 * The Implementation of MatrixVecResource.
 * @author VIJAY AKULA
 *
 */
public class MatrixVecServerResource extends ServerResource
implements MatrixVecResource{
    /**
     * Instance of matrix Helper class.
     */
    private MatrixHelper matrixHelper = new MatrixHelper();
    
    /**
     * Instance of matrix display logger error
     */
    private DisplayLoggerError display = new DisplayLoggerError();
    /**
     * This method is used to perform vec operation on a matrix if a matrix is
     * {1 2 3, 4 5 6, 7 8 9} then the output would be a colum matrix with
     * elements {1 4 7 2 5 8 3 6 9}.
     * 
     * @param matrix
     *            matrix is the input matrix on which vector operation has
     *            to be performed.
     * @return namedMatrix Returns the result as a column matrix which is a
     *         NamedMatrix.
     */
    @Post
    public NamedMatrix vec(final NamedMatrix matrix) {
        if (matrix == null) {
            display.displayError(MatrixConstants.VEC_MATRIX_NOTPOSSIBLE,
                    MatrixConstants.NO_INPUT_SPECIFIED);
        }
        RealMatrix realMatrix = MatrixUtils.getVecMatrix(matrixHelper
                .toRealMatrix(matrix));

        NamedMatrix vecMatrix = matrixHelper.toNamedMatrix(realMatrix,
                MatrixConstants.VEC_MATRIX_RETURN_NAME);
        return vecMatrix;
    }


}
