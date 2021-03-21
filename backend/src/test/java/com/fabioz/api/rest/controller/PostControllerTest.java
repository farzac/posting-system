package com.fabioz.api.rest.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * @author fabioz
 *
 */
@ExtendWith(MockitoExtension.class)
class PostControllerTest {
   
	//@Mock
	//private IScheduleService iScheduleService;

    @Test
    void saveScheduleTest(){
        /*
    	// Arrange
    	Schedule schedule = new Schedule();
        schedule.setName("pauta1");
        
        IScheduleService iScheduleService = Mockito.mock(IScheduleService.class);
        this.scheduleControler = new ScheduleControler(iScheduleService);

        when(this.iScheduleService.saveSchedule(schedule)).thenReturn(schedule);

        // Action
        ResponseEntity<Schedule> httpStatus = this.scheduleControler.saveSchedule(schedule);

        // Assert
        assertEquals(HttpStatus.CREATED, httpStatus.getStatusCode());
    */
    }

    @Test
    void getAssociatesTest(){
        // Arrange
    	/*
    	Schedule schedule = new Schedule();
    	schedule.setName("pauta1");
        List<Schedule> schedules = new ArrayList<>();
        schedules.add(schedule);
        
        doReturn(schedules).when(iScheduleService).getAllSchedules();

        // Action
        ResponseEntity<List<Schedule>> httpStatus = this.scheduleControler.getSchedules();

        // Assert
        assertEquals(HttpStatus.OK, httpStatus.getStatusCode());
    	*/
    }

    @Test
    void deleteAssociateTest(){
        // Arrange
        /*
    	Integer id = 1;
        Schedule schedule = new Schedule();
        schedule.setId(id);
        
        
        // void methods 
        doNothing().when(iScheduleService).deleteSchedule(1);
        
        
        // Action
        ResponseEntity<?> httpStatus = this.scheduleControler.deleteSchedule(schedule.getId());

        // Assert
        assertEquals(HttpStatus.OK, httpStatus.getStatusCode());
    	*/
    }
}

