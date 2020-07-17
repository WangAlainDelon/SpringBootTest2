package com.wx.scheduled.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * User: Mr.Wang
 * Date: 2019/10/28
 */
public enum  TaskIdEnum {
    TASK_TODO("TASK_TODO", "定时推送待办任务");

    TaskIdEnum(String taskId, String desc) {
        this.taskId = taskId;
        this.desc = desc;
    }

    /**
     * 任务唯一id
     */
    private String taskId;

    /**
     * 任务类型描述
     */
    private String desc;


    public String getTaskId() {
        return taskId;
    }

    public String getDesc() {
        return desc;
    }

    public static TaskIdEnum acquire(final String taskId) {
        Optional<TaskIdEnum> serializeEnum =
                Arrays.stream(TaskIdEnum.values())
                        .filter(v -> Objects.equals(v.getTaskId(), taskId))
                        .findFirst();
        return serializeEnum.orElse(TaskIdEnum.TASK_TODO);
    }

    public static List<TaskIdEnum> getEnumList() {
        return Arrays.asList(TaskIdEnum.values());
    }

}
