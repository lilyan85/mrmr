package cn.edu.xmu.dm.mrmr;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.lazy.IBk;
import weka.classifiers.meta.AdaBoostM1;
import weka.classifiers.meta.Bagging;
import weka.classifiers.trees.DecisionStump;
import weka.classifiers.bayes.*;
import weka.classifiers.trees.RandomForest;
import weka.classifiers.functions.supportVector.*;
import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

public class mrmr {
	public static void main(String[] args) throws Exception {
//		RandomForest m_classifier = new RandomForest();
//		Bagging m_classifier = new Bagging();
//		Classifier m_classifier = new NaiveBayes();
//		Classifier m_classifier = new SupportVectorMachineModel();

//		m_classifier.setNumTrees(120);
//		m_classifier.setNumExecutionSlots(1);
//	    m_classifier.setNumIterations(44);
//	    m_classifier.bagSizePercentTipText()
//		m_classifier.setSeed(0);

		
//		IBk m_classifier = new IBk(25);
		// AdaBoostM1 m_classifier = new AdaBoostM1();
		// m_classifier.setClassifier(new DecisionStump());
	//	 m_classifier.setNumIterations(200);
		File inputFile = new File("D:/sl/167.arff");
		ArffLoader atf = new ArffLoader();
		atf.setFile(inputFile);
		Instances inst = atf.getDataSet(); 
		inst.setClassIndex(inst.numAttributes() - 1);
/*		int[] remove31 = {115,141,62,152,183,68,36,57,99,22,
				162,9,82,47,120,94,78,52,31,178,26,
				73,89,131,136,23,173,185,153,127,124 };*/
		int[]  remove60= {
				
				22 , 40 , 61 , 8 , 35 , 1 , 6 , 133 , 15 , 93, 
				162 , 74 , 13 , 145 , 18 , 116 , 98 , 19 , 16 , 119, 
				82 , 103 , 17 , 89 , 58 , 81 , 114 , 77 , 113 , 36, 
				5 , 99 , 14 , 156 , 9 , 135 , 137 , 3 , 165 , 4, 
				78 , 10 , 151 , 140 , 53 , 72 , 66 , 134 , 12 , 30, 
				76 , 120 , 118 , 130 , 141 , 154 , 44 , 115 , 166 , 80, 
				
	
			
			
				
				

		};
		
		Remove remove = new Remove();

		remove.setAttributeIndicesArray(remove60);
		remove.setInvertSelection(true);
		remove.setInputFormat(inst);
//
		Instances instancesTrain = Filter.useFilter(inst, remove);
//
//		System.out.println(instancesTrain.numAttributes());
		BufferedWriter writer = new BufferedWriter(new FileWriter("d:/sl/167_60.arff"));
		writer.write(instancesTrain.toString());
		writer.flush();
		writer.close();

	}
}
