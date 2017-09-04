package me.fru1t.whatever;

import java.util.function.Consumer;

import org.eclipse.jdt.annotation.Nullable;

/**
 * I was about to post this to StackOverflow; however, some research led to this:
 * http://www.informit.com/articles/article.aspx?p=2191424&seqNum=2
 * 
 * In essence, there are 4 kinds of method references (the double colon ::)
 * 1. Reference to a static method (Class::staticMethod)
 *    This produces exactly what you expect, a reference to the static method.
 *    
 * 2. Reference to a /bound/ non-static method (instance::nonStaticMethod)
 *    This produces exactly what you expect, a reference to the method for that instance.
 *    
 * 3. Reference to an /unbound/ non-static method (Class::nonStaticMethod)
 *    This produces a lambda in the form of (Class c) -> ( return c.nonStaticMethod(); }
 *    
 * 4. Reference to a constructor (Class::new)
 *    This produces exactly what you expect.
 *    
 * #3 is the solution to the question I had, where I was referencing an unbound non-static
 * method (PassthroughEventListener::onEvent*) which morphed into the
 * Consumer<PassthroughEventListener> interface.
 */
public class StaticAccessToNonStaticMethod {
	public static class EventGeneratingClass {
		public interface EventGenerator {
			void onEvent();
		}
		
		private EventGenerator eventListener;
		
		public void setEventListener(EventGenerator eventListener) {
			this.eventListener = eventListener;
		}
	}
	
	public interface PassthroughEventListener {
		void onEventOne();
		void onEventTwo();
	}
	
	@Nullable
	private PassthroughEventListener listener;
	
	public StaticAccessToNonStaticMethod(EventGeneratingClass generator1, EventGeneratingClass generator2) {
		generator1.setEventListener(() -> eventHandlerFunction(PassthroughEventListener::onEventOne));
		generator2.setEventListener(() -> eventHandlerFunction(PassthroughEventListener::onEventTwo));
	}
	
	private void eventHandlerFunction(Consumer<PassthroughEventListener> action) {
		if (listener != null) {
			action.accept(listener);
		}
	}
}
