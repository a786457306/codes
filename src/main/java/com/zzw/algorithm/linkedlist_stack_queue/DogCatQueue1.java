package com.zzw.algorithm.linkedlist_stack_queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * DogCatQueue
 *
 * @author Daydreamer
 * @date 2018/3/30 13:04
 */
public class DogCatQueue1 {
    public class Pet {
        private String type;
        public Pet(String type) {
            this.type = type;
        }
        public String getPetType() {
            return this.type;
        }
    }
    public class Dog extends Pet {
        public Dog() {
            super("dog");
        }
    }
    public class Cat extends Pet {
        public Cat() {
            super("cat");
        }
    }

    // 添加元素的时候加的是pet队列，同时标识宠物类型和编号
    // 自己封装数据项
    public static class PetEnterQueue{
        private Pet pet;
        private long count;

        public PetEnterQueue(Pet pet, long count){
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet(){
            return this.pet;
        }

        public long getCount() {
            return count;
        }

        public String getEnterPetType(){
            return this.pet.getPetType();
        }
    }

    //队列里就放宠物进队列的对象
    public static class DogCatQueue{
        private Queue<PetEnterQueue> dogQ;
        private Queue<PetEnterQueue> catQ;
        private long index;

        public DogCatQueue(){
            this.dogQ = new LinkedList<PetEnterQueue>();
            this.catQ = new LinkedList<PetEnterQueue>();
            this.index = 0;
        }

        public void add(Pet pet){
            if (pet.getPetType().equals("dog")){
                this.dogQ.add(new PetEnterQueue(pet, this.index++));
            } else if (pet.getPetType().equals("cat")){
                this.catQ.add(new PetEnterQueue(pet, this.index++));
            } else {
                throw new RuntimeException("error, not dog or cat");
            }
        }

        public Pet pollAll(){
            if (!this.dogQ.isEmpty() && !this.catQ.isEmpty()){
                if (this.dogQ.peek().getCount() < this.catQ.peek().getCount()){
                    return this.catQ.poll().getPet();
                } else {
                    return this.dogQ.poll().getPet();
                }
            } else if (!this.dogQ.isEmpty()) {
                return this.dogQ.poll().getPet();
            } else if (!this.catQ.isEmpty()) {
                return this.catQ.poll().getPet();
            } else {
                throw new RuntimeException("err, queue is empty!");
            }
        }

        public Dog pollDog() {
            if (!this.isDogQueueEmpty()) {
                return (Dog) this.dogQ.poll().getPet();
            } else {
                throw new RuntimeException("Dog queue is empty!");
            }
        }

        public Cat pollCat() {
            if (!this.isCatQueueEmpty()) {
                return (Cat) this.catQ.poll().getPet();
            } else
                throw new RuntimeException("Cat queue is empty!");
        }

        public boolean isEmpty() {
            return this.dogQ.isEmpty() && this.catQ.isEmpty();
        }

        public boolean isDogQueueEmpty() {
            return this.dogQ.isEmpty();
        }

        public boolean isCatQueueEmpty() {
            return this.catQ.isEmpty();
        }

    }
}
