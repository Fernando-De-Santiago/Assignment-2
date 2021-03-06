package io.coodoo.workhorse.jobengine.boundary;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import io.coodoo.workhorse.config.boundary.JobEngineConfigService;
import io.coodoo.workhorse.jobengine.entity.JobExecutionStatus;

/**
 * Basic configuration that can be changed via {@link JobEngineConfigService}
 * 
 * @author coodoo GmbH (coodoo.io)
 */
public final class JobEngineConfig {

    private JobEngineConfig() {}

    /**
     * ZoneId Object time zone for LocalDateTime instance creation. Default is UTC
     */
    public static ZoneId timeZone = ZoneId.of("UTC");

    /**
     * Job queue poller interval in seconds
     */
    public static int JOB_QUEUE_POLLER_INTERVAL = 5;

    /**
     * Max amount of executions to load into the memory queue per job
     */
    public static int JOB_QUEUE_MAX = 1000;

    /**
     * Min amount of executions in memory queue before the poller gets to add more
     */
    public static int JOB_QUEUE_MIN = 100;

    /**
     * A zombie is an execution that is stuck in status {@link JobExecutionStatus#RUNNING} for this amount of minutes (if set to 0 the hunt is off)
     */
    public static int ZOMBIE_RECOGNITION_TIME = 120;

    /**
     * If an execution is stuck in status {@link JobExecutionStatus#RUNNING} and doesn't change, it has became a zombie! Once found we have a cure!
     */
    public static JobExecutionStatus ZOMBIE_CURE_STATUS = JobExecutionStatus.ABORTED;

    /**
     * Days until by minute statistic records gets deleted (0 to keep all)
     */
    public static int DAYS_UNTIL_STATISTIC_MINUTES_DELETION = 10;

    /**
     * Days until hourly statistic records gets deleted (0 to keep all)
     */
    public static int DAYS_UNTIL_STATISTIC_HOURS_DELETION = 30;

    /**
     * Log change pattern. Placeholder <code>%s</code> for changeParameter, changeOld and changeNew in this order <br>
     * Default is <code>Changed %s from '%s' to '%s'</code>
     */
    public static String LOG_CHANGE = "%s changed from '%s' to '%s'";

    /**
     * Execution log timestamp pattern. Default is <code>[HH:mm:ss.SSS]</code>
     */
    public static DateTimeFormatter LOG_TIME_FORMATTER = DateTimeFormatter.ofPattern("'['HH:mm:ss.SSS']'");

    /**
     * Execution log info marker. Default is none
     */
    public static String LOG_INFO_MARKER = null;

    /**
     * Execution log warn marker. Default is <code>[WARN]</code>
     */
    public static String LOG_WARN_MARKER = "[WARN]";

    /**
     * Execution log error marker. Default is <code>[ERROR]</code>
     */
    public static String LOG_ERROR_MARKER = "[ERROR]";

}
