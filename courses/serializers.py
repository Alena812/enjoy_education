from rest_framework import serializers
from .models import *


class CourseSerializer(serializers.ModelSerializer):
    class Meta:
        model = Course
        fields = ('title', 'description')


class LessonsSerializer(serializers.ModelSerializer):
    class Meta:
        model = Lesson
        fields = ('id', 'short_info', 'is_valid', 'course_id')


class LessonPostSerializer(serializers.ModelSerializer):
    class Meta:
        model = Lesson
        fields = ('short_info', 'course_id', 'long_info', 'is_valid')

class EnterToCourseSerializer(serializers.ModelSerializer):
    class Meta:
        model = UserHasCourse
        fields = ('course', 'periodicity', 'user')
