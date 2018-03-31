package com.dulandias.dna.sequence.alignment;

import java.util.Scanner;

/**
 *
 * @author DulanDias (AS2014347)
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("-------------------------------------------------\n");
        System.out.println("DNA Sequence Alignment for Computational Biology\n");
        System.out.println("-------------------------------------------------");
        System.out.println("Dulan Dias (AS2014347)");
        System.out.println("-------------------------------------------------");
              
        System.out.println("Select an algorithm for Sequence Alignment:");
        System.out.println("1 - Global Alignment (Needleman-Wunsch Algorithm)");
        System.out.println("2 - Local Alignmnet (Smith-Waterman Algorithm)");
        
        System.out.println("\nChoose a number: ");
        int algo = sc.nextInt();
        
        while (algo!=1 && algo!=2){
        
            System.out.println("Invalid response!");
            System.out.println("\nChoose a number: ");
            algo = sc.nextInt();
            
        }
        
        int match = 1;
        int mismatch = -1;
        int gap = -2;
        
        System.out.println("\nEnter value for Match Score (e.g.: 1): ");
        match = sc.nextInt();
        
        System.out.println("\nEnter value for Mismatch Score (e.g.: -1):");
        mismatch = sc.nextInt();
        
        System.out.println("\nEnter value for Gap Penalty (e.g.: -2):");
        gap = sc.nextInt();
        
        String sequence1 = "GCCCTAGCG";
        String sequence2 = "GCGCAATG";
        
        System.out.println("\nEnter Sequence One: ");
        sequence1 = sc.next();
        
        System.out.println("\nEnter Sequence Two: ");
        sequence2 = sc.next();
        
        if (algo==1)
        {
            NeedlemanWunsch aligner = new NeedlemanWunsch(sequence1, sequence2, match, mismatch, gap);
            String[] alignment = aligner.getAlignment();
            
            System.out.println("\n-------------------------------------------------");
            System.out.println("\nGlobal Alignment - Needleman Wunsch Algorithm\n");
            
            System.out.println("Sequence 1: "+alignment[0]);
            System.out.println("Sequence 2: "+alignment[1]);  
        }
        else if (algo==2)
        {
            SmithWaterman aligner = new SmithWaterman(sequence1, sequence2, match, mismatch, gap);
            String[] alignment = aligner.getAlignment();
            
            System.out.println("\n-------------------------------------------------");
            System.out.println("\nLocal Alignment - Smith Waterman Algorithm\n");
            
            System.out.println("Sequence 1: "+alignment[0]);
            System.out.println("Sequence 2: "+alignment[1]);  
        } 
        
        System.out.println("\n-------------------------------------------------");
        System.out.println("Program executed successfully!");
        System.out.println("-------------------------------------------------");
        
    }
    
}
