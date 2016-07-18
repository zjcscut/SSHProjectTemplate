package cn.mock;

/**
 * @author zjc
 * @version 2016/7/18 23:43
 * @function
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatcher;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.exceptions.verification.NoInteractionsWanted;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TestMock {

	//验证行为
	@Test
	public void verify_behaviour() {
		//模拟创建一个List对象
		List mock = mock(List.class);

		//使用mock对象
		mock.add(1);
		mock.clear();

		//验证前两个方法是否发生过
		verify(mock).add(1);
		verify(mock).clear();
	}

	//模拟期望结果
	@Test
	public void when_thenReturn() {
		//mock一个Iterator类
		Iterator iterator = mock(Iterator.class);
		//预设当iterator调用next()时第一次返回hello，第n次都返回world
		when(iterator.next()).thenReturn("hello").thenReturn("world");

		String result = iterator.next() + " " + iterator.next() + " " + iterator.next();
		//验证结果
		assertEquals("hello world world", result);
	}

	@Test
	public void when_thenThorw() throws IOException {
		OutputStream outputStream = mock(OutputStream.class);
		OutputStreamWriter writer = new OutputStreamWriter(outputStream);

		//预设当流关闭时抛出异常
		doThrow(new IOException()).when(outputStream).close();

		outputStream.close();
	}

	//参数匹配
	@Test
	public void with_arguments() {
		Comparable comparable = mock(Comparable.class);
		//预设根据不同的参数返回不同的结果
		when(comparable.compareTo("test")).thenReturn(1);
		when(comparable.compareTo("hello")).thenReturn(2);
		assertEquals(1, comparable.compareTo("test"));
		assertEquals(2, comparable.compareTo("hello"));

		//没有预设值返回默认值
		assertEquals(0, comparable.compareTo("no stub"));
	}

	//匹配自己想要的任意参数
	@Test
	public void with_unspecified_arguments() {
		List list = mock(List.class);
		//匹配任意参数
		when(list.get(anyInt())).thenReturn(1);
		when(list.contains(argThat(new IsValid()))).thenReturn(true);
		assertEquals(1, list.get(1));
		assertEquals(1, list.get(999));
		assertTrue(list.contains(1));
		assertTrue(list.contains(3));
	}

	private class IsValid extends ArgumentMatcher<List> {
		@Override
		public boolean matches(Object o) {
			return (Integer) o == 1 || (Integer) o == 2;
		}
	}

	//验证确切的调用次数
	@Test
	public void verifying_number_of_invocations() {
		List list = mock(List.class);
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(3);
		list.add(3);
		list.add(3);
		//验证是否被调用一次，等效于下面的times(1)
		verify(list).add(1);
		verify(list, times(1)).add(1);
		//验证是否被调用2次
		verify(list, times(2)).add(2);
		//验证是否被调用3次
		verify(list, times(3)).add(3);
		//验证是否从未被调用过
		verify(list, never()).add(4);
		//验证至少调用一次
		verify(list, atLeastOnce()).add(1);
		//验证至少调用2次
		verify(list, atLeast(2)).add(2);
		//验证至多调用3次
		verify(list, atMost(3)).add(3);
	}

	//模拟方法体抛出异常
	@Test(expected = RuntimeException.class)
	public void doThrow_when() {
		List list = mock(List.class);
		doThrow(new RuntimeException()).when(list).add(1);
		list.add(1);
	}

	//验证执行顺序
	@Test
	public void verification_in_order() {
		List list = mock(List.class);
		List list2 = mock(List.class);
		list.add(1);
		list2.add("hello");
		list.add(2);
		list2.add("world");
		//将需要排序的mock对象放入InOrder
		InOrder inOrder = inOrder(list, list2);
		//下面的代码不能颠倒顺序，验证执行顺序
		inOrder.verify(list).add(1);
		inOrder.verify(list2).add("hello");
		inOrder.verify(list).add(2);
		inOrder.verify(list2).add("world");
	}


	//确保模拟对象上无互动发生
	@Test
	public void verify_interaction() {
		List list = mock(List.class);
		List list2 = mock(List.class);
		List list3 = mock(List.class);
		list.add(1);
		verify(list).add(1);
		verify(list, never()).add(2);
		//验证零互动行为
		verifyZeroInteractions(list2, list3);
	}

	//找出冗余的互动(即未被验证到的)
	@Test(expected = NoInteractionsWanted.class)
	public void find_redundant_interaction() {
		List list = mock(List.class);
		list.add(1);
		list.add(2);
		verify(list, times(2)).add(anyInt());
		//检查是否有未被验证的互动行为，因为add(1)和add(2)都会被上面的anyInt()验证到，所以下面的代码会通过
		verifyNoMoreInteractions(list);

		List list2 = mock(List.class);
		list2.add(1);
		list2.add(2);
		verify(list2).add(1);
		//检查是否有未被验证的互动行为，因为add(2)没有被验证，所以下面的代码会失败抛出异常
		verifyNoMoreInteractions(list2);
	}

	//使用注解来快速模拟,在基类添加 MockitoJUnitRunner
	@Mock
	private List mockList;

	@Test
	public void shorthand() {
		mockList.add(1);
		verify(mockList).add(1);
	}

	//连续调用
	@Test(expected = RuntimeException.class)
	public void consecutive_calls() {
		//模拟连续调用返回期望值，如果分开，则只有最后一个有效
		when(mockList.get(0)).thenReturn(0);
		when(mockList.get(0)).thenReturn(1);
		when(mockList.get(0)).thenReturn(2);
		when(mockList.get(1)).thenReturn(0).thenReturn(1).thenThrow(new RuntimeException());
		assertEquals(2, mockList.get(0));
		assertEquals(2, mockList.get(0));
		assertEquals(0, mockList.get(1));
		assertEquals(1, mockList.get(1));
		//第三次或更多调用都会抛出异常
		mockList.get(1);
	}

	//使用回调生成期望值
	@Test
	public void answer_with_callback() {
		//使用Answer来生成我们我们期望的返回
		when(mockList.get(anyInt())).thenAnswer(new Answer<Object>() {
			@Override
			public Object answer(InvocationOnMock invocation) throws Throwable {
				Object[] args = invocation.getArguments();
				return "hello world:" + args[0];
			}
		});
		assertEquals("hello world:0", mockList.get(0));
		assertEquals("hello world:999", mockList.get(999));
	}

	//监控真实对象,使用spy来监控真实的对象，需要注意的是此时我们需要谨慎的使用when-then语句，而改用do-when语句
	@Test(expected = IndexOutOfBoundsException.class)
	public void spy_on_real_objects() {
		List list = new LinkedList();
		List spy = spy(list);
		//下面预设的spy.get(0)会报错，因为会调用真实对象的get(0)，所以会抛出越界异常
		//when(spy.get(0)).thenReturn(3);

		//使用doReturn-when可以避免when-thenReturn调用真实对象api
		doReturn(999).when(spy).get(999);
		//预设size()期望值
		when(spy.size()).thenReturn(100);
		//调用真实对象的api
		spy.add(1);
		spy.add(2);
		assertEquals(100, spy.size());
		assertEquals(1, spy.get(0));
		assertEquals(2, spy.get(1));
		verify(spy).add(1);
		verify(spy).add(2);
		assertEquals(999, spy.get(999));
		spy.get(2);
	}

	//修改对未预设的调用返回默认期望值
	@Test
	public void unstubbed_invocations() {
		//mock对象使用Answer来对未预设的调用返回默认期望值
		List mock = mock(List.class, new Answer() {
			@Override
			public Object answer(InvocationOnMock invocation) throws Throwable {
				return 999;
			}
		});
		//下面的get(1)没有预设，通常情况下会返回NULL，但是使用了Answer改变了默认期望值
		assertEquals(999, mock.get(1));
		//下面的size()没有预设，通常情况下会返回0，但是使用了Answer改变了默认期望值
		assertEquals(999, mock.size());
	}

	//捕获参数来进一步断言
	@Test
	public void capturing_args() {
		PersonDao personDao = mock(PersonDao.class);
		PersonService personService = new PersonService(personDao);

		ArgumentCaptor<Person> argument = ArgumentCaptor.forClass(Person.class);
		personService.update(1, "jack");
		verify(personDao).update(argument.capture());
		assertEquals(1, argument.getValue().getId());
		assertEquals("jack", argument.getValue().getName());
	}

	class Person {
		private int id;
		private String name;

		Person(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}
	}

	interface PersonDao {
		public void update(Person person);
	}

	class PersonService {
		private PersonDao personDao;

		PersonService(PersonDao personDao) {
			this.personDao = personDao;
		}

		public void update(int id, String name) {
			personDao.update(new Person(id, name));
		}
	}

	//真实的部分mock
	@Test
	public void real_partial_mock(){
		//通过spy来调用真实的api
		List list = spy(new ArrayList());
		assertEquals(0,list.size());
		 A  a = mock(A.class);
		//通过thenCallRealMethod来调用真实的api
		when(a.doSomething(anyInt())).thenCallRealMethod();
		assertEquals(999,a.doSomething(999));
	}


	class A{
		public int doSomething(int i){
			return i;
		}
	}

	//重置mock
	@Test
	public void reset_mock(){
		List list = mock(List.class);
		when(list.size()).thenReturn(10);
		list.add(1);
		assertEquals(10,list.size());
		//重置mock，清除所有的互动和预设
		reset(list);
		assertEquals(0,list.size());
	}
}