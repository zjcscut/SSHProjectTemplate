package cn.ppfix;

import org.activiti.engine.*;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author zhangjinci
 * @version 2016/7/4 18:14
 */
public class TestActiviti extends cn.ppfix.BasicTest {

//    @Autowired
//    private ProcessEngineFactoryBean processEngine;

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private IdentityService identityService;

    @Test
    public void testEvent(){
        System.out.println("Number of process definitions: " + repositoryService.createProcessDefinitionQuery().count());
    }

    @Test
    public void delDeployment(){
        repositoryService.deleteDeployment("25001",true); //设置为级联删除
    }

    @Test
    public void TestAll(){
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("LeaveFlow");
        System.out.println(processInstance.getId());
        System.out.println(processInstance.getProcessDefinitionId());
        System.out.println(processInstance.getProcessDefinitionKey());

        List<Task> tasks = taskService.createTaskQuery().taskAssignee("老板").list();
        for (Task task : tasks) {
            System.out.println(task.getName() + " : " + task.getAssignee());

            taskService.claim(task.getId(), "老板");
        }

        for (Task task : tasks){
            taskService.complete(task.getId());
            System.out.println(task.getName() + " : " + task.getId() + " completed ");
        }


        HistoricProcessInstance hpInstance =
                historyService.createHistoricProcessInstanceQuery()
                        .processInstanceId(processInstance.getId()).singleResult();
        System.out.println("end time: " + hpInstance.getEndTime());
    }
}
