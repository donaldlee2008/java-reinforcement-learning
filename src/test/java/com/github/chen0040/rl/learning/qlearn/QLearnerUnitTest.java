package com.github.chen0040.rl.learning.qlearn;


import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.*;


/**
 * Created by xschen on 6/5/2017.
 */
public class QLearnerUnitTest {

   @Test
   public void test_q_learn(){
      int stateCount = 100;
      int actionCount = 10;

      QLearner learner = new QLearner(stateCount, actionCount);


      Random random = new Random();
      int currentStateId = random.nextInt(stateCount);
      for(int time=0; time < 1000; ++time){

         int actionId = learner.selectAction(currentStateId);
         System.out.println("Controller does action-"+actionId);

         int newStateId = random.nextInt(actionCount);
         double reward = random.nextDouble();

         System.out.println("Now the new state is "+newStateId);
         System.out.println("Controller receives Reward = "+reward);

         learner.update(currentStateId, actionId, newStateId, reward);
         currentStateId = newStateId;
      }
   }
}
