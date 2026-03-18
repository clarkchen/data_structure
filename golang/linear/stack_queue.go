package linear

type Stack[T any] struct {
	data []T
}

func (s *Stack[T]) Push(v T) {
	s.data = append(s.data, v)
}

func (s *Stack[T]) Pop() (T, bool) {
	var zero T
	if len(s.data) == 0 {
		return zero, false
	}
	v := s.data[len(s.data)-1]
	s.data = s.data[:len(s.data)-1]
	return v, true
}

func (s *Stack[T]) Peek() (T, bool) {
	var zero T
	if len(s.data) == 0 {
		return zero, false
	}
	return s.data[len(s.data)-1], true
}

func (s *Stack[T]) Size() int { return len(s.data) }

func (s *Stack[T]) IsEmpty() bool { return len(s.data) == 0 }

type Queue[T any] struct {
	data []T
}

func (q *Queue[T]) Offer(v T) {
	q.data = append(q.data, v)
}

func (q *Queue[T]) Poll() (T, bool) {
	var zero T
	if len(q.data) == 0 {
		return zero, false
	}
	v := q.data[0]
	q.data = q.data[1:]
	return v, true
}

func (q *Queue[T]) Peek() (T, bool) {
	var zero T
	if len(q.data) == 0 {
		return zero, false
	}
	return q.data[0], true
}

func (q *Queue[T]) Size() int { return len(q.data) }

func (q *Queue[T]) IsEmpty() bool { return len(q.data) == 0 }
