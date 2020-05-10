from django.shortcuts import render, get_object_or_404
from django.http import Http404
from rest_framework import viewsets, status
from rest_framework.decorators import action
from rest_framework.response import Response
from .serializers import *
from .models import *


class CoursesViewSet(viewsets.ModelViewSet):
    serializer_class = CourseSerializer
    queryset = Course.objects.all()

    @action(methods=['get'], detail=True)  # add permission classes
    def my_courses(self, request, pk=None):
        queryset = Course.objects.filter(creator=self.request.user)
        serializer = CourseSerializer(queryset, many=True)
        return Response(serializer.data, status=200)


class LessonViewSet(viewsets.ViewSet):

    def list(self, request):
        course_id = self.request.GET.get('course_id')
        queryset = Lesson.objects.filter(course__id=course_id)
        serializer = LessonsSerializer(queryset, many=True)
        return Response(serializer.data)

    def retrieve(self, request, pk=None):
        queryset = Lesson.objects.all()
        lesson = get_object_or_404(queryset, pk=pk)
        serializer = LessonPostSerializer(lesson)
        return Response(serializer.data)

    def create(self, request):
        course_id = self.request.GET.get('course_id')
        lesson = LessonPostSerializer(data=request.data)
        if lesson.is_valid():
            lesson.save(course_id=course_id, is_valid=False)
            return Response(status=201)
        else:
            return Response(status=400)

    def destroy(self, request, pk):
        try:
            queryset = Lesson.objects.all()
            lesson = get_object_or_404(queryset, pk=pk)
            lesson.delete()
        except Http404:
            pass
        return Response(status=status.HTTP_204_NO_CONTENT)

    @action(methods=['get'], detail=True)
    def available(self, request, pk=None):
        course_id = self.request.GET.get('course_id')
        queryset = Lesson.objects.filter(course__id=course_id).filter(is_valid=True)
        serializer = LessonPostSerializer(queryset, many=True)
        return Response(serializer.data)
