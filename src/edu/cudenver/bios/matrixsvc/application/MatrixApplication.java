/*
 * Power Service for the GLIMMPSE Software System.  Processes
 * incoming HTTP requests for power, sample size, and detectable
 * difference
 * 
 * Copyright (C) 2011 Regents of the University of Colorado.  
 *
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
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package edu.cudenver.bios.matrixsvc.application;

import org.restlet.Application;
import org.restlet.Context;
import org.restlet.Restlet;
import org.restlet.Router;

import edu.cudenver.bios.matrixsvc.resource.*;
import edu.cudenver.bios.matrixsvc.resource.test.FTestResource;


/**
 * Main Restlet application class for the Matrix Service.
 * Defines URI mappings to the appropriate resource class.
 * 
 * @author Jonathan Cohen
 */
public class MatrixApplication extends Application
{   
    /**
     * Class which dispatches http requests to the appropriate
     * handler class for the matrix service.
     * 
     * @param parentContext
     */
    public MatrixApplication(Context parentContext) throws Exception
    {
        super(parentContext);

        MatrixLogger.getInstance().info("Matrix service starting.");
    }

    /**
     * Define URI mappings for incoming power, sample size,
     * and detectable difference requests
     */
    @Override
    public Restlet createRoot() 
    {
        // Create a router Restlet that routes each call to a new instance of Resource.
        Router router = new Router(getContext());
        
        // Defines only one default route, self-identifies server
        router.attachDefault(DefaultResource.class);

        /* attributes of matrix resources */
        // Matrix Addition resource 
        router.attach("/matrix/addition", MatrixAdditionResource.class);
        
        // Matrix Subtraction resource
        router.attach("/matrix/subtraction", MatrixSubtractionResource.class);
        
        // Multiplication resource
        router.attach("/matrix/mult", MatrixMultiplicationResource.class);// Scalar Multiplication resource
        
        // Scalar Multiplication resource
        router.attach("/matrix/mult/scalar", MatrixScalarMultiplicationResource.class);
        
        // Element-Wise Multiplication resource
        router.attach("/matrix/mult/elementWise", MatrixElementWiseMultiplicationResource.class);
        
        // Horizontal Direct Multiplication resource
        router.attach("/matrix/mult/horizontalDir", MatrixHorizontalDirectMultiplicationResource.class);
        
        // Kronecker Product Multiplication resource
        router.attach("/matrix/mult/kronecker", MatrixKroneckerProductResource.class);
        
        // Matrix Inversion resource
        router.attach("/matrix/inverse", MatrixInversionResource.class);
        
        // Matrix Rank resource
        router.attach("/matrix/rank", MatrixRankResource.class);
        
        // Matrix Trace resource
        router.attach("/matrix/trace", MatrixTraceResource.class);
        
        // Matrix Positive Definite resource
        router.attach("/matrix/positiveDefinite", MatrixPositiveDefiniteResource.class);
        
        // Matrix Orthogonal Polynomial Contrast resource
        router.attach("/matrix/contrast", MatrixContrastResource.class);
        
        //Matrix Cholesky Decomposition resource
        router.attach("/matrix/decomposition/cholesky", MatrixDecompositionCholeskyResource.class);
        
        //Matrix Vec resource
        router.attach("/matrix/vec", MatrixVecResource.class);
        
        //Matrix Vech resource
        router.attach("/matrix/vech", MatrixVechResource.class);
        
        
        // unit test resource - easier to collaborate with remote testers this way
        router.attach("/testf", FTestResource.class);
        
        return router;
    }
}
