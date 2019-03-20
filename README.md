# queue
队列相关操作，后续补充各个知识点的实现原理和实例，后期扩展到消息队列

## queuq
* Queue
* Deque
* AbstractQueue
    * PriorityQueue
    * ConcurrentLinkedQueue
* BlockingQueue
    * ArrayBlockingQueue
    * LinkedBlockingQueue
    * DelayQueue
    * PriorityBlockingQueue
    * SynchronousQueue

## BlockingQueue
* add(e)//队列未满时，返回true；队列满则抛出IllegalStateException(“Queue full”)异常——AbstractQueue
* offer(e)//队列未满时，返回true；队列满时返回false。非阻塞立即返回。
* offer(e, time, unit)//设定等待的时间，如果在指定时间内还不能往队列中插入数据则返回false，插入成功返回true。
* put(e)//队列未满时，直接插入没有返回值；队列满时会阻塞等待，一直等到队列未满时再插入。
* remove()//队列不为空时，返回队首值并移除；队列为空时抛出NoSuchElementException()异常——AbstractQueue
* poll()//队列不为空时返回队首值并移除；队列为空时返回null。非阻塞立即返回。
* poll(time, unit)//设定等待的时间，如果在指定时间内队列还未孔则返回null，不为空则返回队首值
* take(e)//队列不为空返回队首值并移除；当队列为空时会阻塞等待，一直等到队列不为空时再返回队首值。


## 知识点
* CAS
* AQS
* ReentrantLock
* Condition