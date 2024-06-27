package Interview;

/*
Question:
You are tasked with designing and implementing a rate limiter for an API. The rate limiter should allow a maximum number of requests per user within a given time frame, using a sliding window algorithm to ensure fairness and accuracy.
Requirements:
Implement the RateLimiter class with the following methods:
boolean allowRequest(String userId) returns true if the request is allowed, otherwise returns false.
Allow a configurable number of requests per user per time frame (e.g., 100 requests per minute).
Use a sliding window algorithm to track and limit requests. This approach should account for requests made at the beginning and end of the time frame more accurately than a fixed window.
Handle edge cases such as requests from different users and requests that fall on the boundary of the time frame.
Explanation: A rate limiter controls the number of requests a user can make to a service within a specified time frame, preventing abuse and ensuring fair usage. The sliding window algorithm offers a more precise control by continuously tracking the request rate and adjusting the allowance dynamically within the specified time frame. This method is particularly effective in scenarios where request patterns can be bursty or unevenly distributed over time.
Single User
5 Req for the window.
Window size is 60s.


Queue<Long> queue. Queue of Timestamps => milliseconds.

When I receive a req, I know the current timestamp.
I will add this to the Last of Queue.
This Queue is sorted by Timestamp.
targetTimestamp = currentTimeStamp -  windowDuration;

t+120, t+140, t+150, t+155, t+160,

Use BinarySearch to find the index of target timestamp in logN.
Decide based on Number of elements from index to end of queue.
Then remove elements older than the targetTimestamp.


Map<UserId, Map<Configuration, Queue<Long>>> userQueueMap -> for each user, for each config, its corresponding queue.

Map<UserId, Set<Configuration>> userConfigMap   -> store config in order of granularity.

*/