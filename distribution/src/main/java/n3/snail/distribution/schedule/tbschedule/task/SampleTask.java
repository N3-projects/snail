package n3.snail.distribution.schedule.tbschedule.task;

import com.taobao.pamirs.schedule.IScheduleTaskDeal;
import com.taobao.pamirs.schedule.IScheduleTaskDealMulti;
import com.taobao.pamirs.schedule.TaskItemDefine;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

/**
 * @author N3 on 2017/11/12.
 */
@Component
public class SampleTask implements IScheduleTaskDealMulti<String> {

    @Override
    public List<String> selectTasks(String taskParameter, String ownSign, int taskItemNum, List<TaskItemDefine> taskItemList, int eachFetchDataNum) throws Exception {
        System.out.println("selectTasks");
        return null;
    }

    @Override
    public boolean execute(String[] tasks, String ownSign) throws Exception {
        System.out.println("execute");
        return false;
    }

    @Override
    public Comparator<String> getComparator() {
        return null;
    }
}
